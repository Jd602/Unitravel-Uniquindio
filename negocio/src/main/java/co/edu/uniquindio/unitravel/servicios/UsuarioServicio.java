package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws Exception;

    Usuario obtenerUsuario(String codigo);

    void eliminarUsuario(String cedula) throws Exception;

    List<Usuario> listarUsuarios();

    Usuario validarLogin(String correo, String password) throws Exception;

    Reserva realizarReserva(Hotel h, Reserva r, Usuario u, int cantidadSillas) throws Exception;

    void eliminarReserva(int codigoReserva) throws Exception;

    Reserva obtenerReserva(int codigoReserva) throws Exception;
    Reserva actualizarReserva(Reserva r) throws Exception;
    List<Reserva> listarReservas();

    List<Hotel> listarHotelesPorCiudad(String nombreCiudad) throws Exception;

    Comentario agregarComentario(Comentario c) throws Exception;

    void recuperarPassword(String email) throws Exception;

}
