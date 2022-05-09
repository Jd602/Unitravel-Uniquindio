package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;


    @Test
    public void registrarComentarioTest()
    {
        AdminHotel adm1 =new AdminHotel("11","admin","admin@hotmail.com","123");
        Ciudad ciudad1 = new Ciudad("city");
        Hotel hotel1 = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm1,ciudad1);
        Usuario usuario1 = new Usuario("4444", "Esteban", "est@hotmail.com", "123456");
        LocalDate fecha1 = LocalDate.parse("2021-05-29");
        Comentario comentario1 = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha1, hotel1, usuario1);

        Comentario comentarioGuardado = comentarioRepo.save(comentario1);

        Assertions.assertNotNull(comentarioGuardado);
    }

    @Test
    public void eliminarComentarioTest()
    {
        AdminHotel adm =new AdminHotel("12","asd","1@hotmail.com","123");
        Ciudad ciudad = new Ciudad("city2");
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        LocalDate fecha = LocalDate.parse("2022-04-12");
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);
        System.out.println("1 "+comentario);

        comentarioRepo.delete(comentarioGuardado);

    }

    @Test
    public void actualizarComentarioTest()
    {
        AdminHotel adm =new AdminHotel("13","adfdmin","admin2@hotmail.com","123");
        Ciudad ciudad = new Ciudad("city3");
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        LocalDate fecha = LocalDate.parse("2022-07-10");
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        comentarioGuardado.setContenido("Buena atencion");
        comentarioGuardado.setCalificacion(Estrella.CUATRO_ESTRELLAS);

        comentarioRepo.save(comentarioGuardado);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarComentarioTest()
    {
        List<Comentario> lista = comentarioRepo.findAll();
        System.out.println(lista);
    }
}
