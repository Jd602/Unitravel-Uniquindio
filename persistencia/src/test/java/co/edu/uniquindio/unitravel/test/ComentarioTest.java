package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
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
    @Autowired
    private AdminHotelRepo adminHotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;


    @Test
    public void registrarComentarioTest()
    {
        LocalDate fecha = insertarFecha();
        Hotel hotel=insertarHotel();
        Usuario usuario=insertarUsuario();
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);
        comentario.setCodigo(1);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        Assertions.assertNotNull(comentarioGuardado);
    }

    @Test
    public void eliminarComentarioTest()
    {
        Hotel hotel = insertarHotel();
        Usuario usuario = insertarUsuario();
        LocalDate fecha = insertarFecha();
        Comentario comentario = new Comentario("Mala atención", Estrella.DOS_ESTRELLAS, fecha, hotel, usuario);

        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        comentarioRepo.delete(comentarioGuardado);
    }

    @Test
    public void actualizarComentarioTest()
    {
        LocalDate fecha=insertarFecha();
        Hotel hotel=insertarHotel();
        Usuario usuario=insertarUsuario();
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

    @Test
    public LocalDate insertarFecha()
    {
        LocalDate fecha = LocalDate.parse("2022-02-21");
        return fecha;
    }

    @Test
    public Hotel insertarHotel()
    {
        AdminHotel adm =new AdminHotel("11","admin","admin@hotmail.com","123");
        adminHotelRepo.save(adm);
        Ciudad ciudad = new Ciudad("city");
        ciudadRepo.save(ciudad);
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        hotelRepo.save(hotel);

        return hotel;
    }

    @Test
    public Usuario insertarUsuario()
    {
        Usuario user = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com",
                "123456");
        usuarioRepo.save(user);

        return user;
    }
}
