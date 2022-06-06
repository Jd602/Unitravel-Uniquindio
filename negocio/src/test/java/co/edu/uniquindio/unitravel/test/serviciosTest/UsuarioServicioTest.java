package co.edu.uniquindio.unitravel.test.serviciosTest;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:registros.sql")
    public void registrarUsuarioTest(){
        Usuario usuario = new Usuario
                ("10","Camilo","camilo@email.com","12345");
        try {
            Usuario guardado = usuarioServicio.registrarUsuario(usuario);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void actualizarUsuarioTest() {
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        try {
            Usuario actualizado = usuarioServicio.actualizarUsuario(usuario);
            actualizado.setNombre("Andres");
            Assertions.assertEquals("Andres", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void obtenerUsuarioTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("4");
        Assertions.assertNotNull(usuario);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void eliminarUsuarioTest(){
        try {
            usuarioServicio.eliminarUsuario("6");
            Usuario eliminado = usuarioServicio.obtenerUsuario("6");
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarUsuarioTest(){
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        usuarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void validadLoginUsuarioTest() {
        try {
            Usuario usuario = usuarioServicio.validarLogin("mikasa666@gmail.com", "pass6");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void realizarReservaTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        Hotel hotel = new Hotel();
        Reserva reserva = new Reserva
                ( LocalDate.of(2022,7,9), LocalDate.of(2022,5,24),
                        LocalDate.of(2022,6,18), EstadoReserva.CONFIRMADA,
                        350000.00,2,usuario);
        try {
            Reserva guardada = usuarioServicio.realizarReserva(hotel,reserva,usuario,2);
            Assertions.assertNotNull(guardada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void eliminarReservaTest(){
        try {
            usuarioServicio.eliminarReserva(2);
            Reserva eliminado = usuarioServicio.obtenerReserva(2);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void actualizarReservaTest() {
        try {
            Reserva reserva = usuarioServicio.obtenerReserva(1);
            reserva.setEstado(EstadoReserva.CANCELADA);
            Reserva actualizada = usuarioServicio.actualizarReserva(reserva);
            Assertions.assertEquals(EstadoReserva.CANCELADA, actualizada.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarReservaTest(){
        List<Reserva> reservas = usuarioServicio.listarReservas();
        reservas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarHotelesPorCiudadTest(){
        try {
            List<Hotel> hoteles = usuarioServicio.listarHotelesPorCiudad("Cali");
            hoteles.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:registros.sql")
    public void agregarComentarioTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        Hotel hotel= new Hotel();
        {
            try {
                Comentario comentario = new Comentario("esto es un comentario",Estrella.CINCO_ESTRELLAS,LocalDate.now(),hotel,usuario);
                Comentario agregado = usuarioServicio.agregarComentario(comentario);
                Assertions.assertNotNull(agregado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    @Sql("classpath:registros.sql")
    public void recuperarPasswordTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("6");
        try {
            usuarioServicio.recuperarPassword(usuario.getCorreo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
