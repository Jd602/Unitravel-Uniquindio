package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;
    private AdminHotel adm =new AdminHotel("11","admin","admin@hotmail.com","123");
    private Ciudad ciudad = new Ciudad("city");

    @Test
    public void registrarComentarioTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        LocalDate fecha = LocalDate.parse("03-04-2022");
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        Assertions.assertNotNull(comentarioGuardado);
    }

    @Test
    public void eliminarComentarioTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        LocalDate fecha = LocalDate.parse("03-04-2022");
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        comentarioRepo.delete(comentarioGuardado);
    }

    @Test
    public void actualizarComentarioTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        LocalDate fecha = LocalDate.parse("03-04-2022");
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
