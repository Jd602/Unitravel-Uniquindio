package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    List<Usuario> findAllByNombre(String nombre);

    @Query("select u from Usuario u where u.nombre = :nombre")
    List<Usuario> buscarPorNombre(String nombre);

    @Query("select u from Usuario u where u.correo = :email and u.password = :password")
    Optional<Usuario> comprobarAutenticacion(String email, String password);

    Optional<Usuario> findByCorreoAndPassword(String correo, String password);
    Optional<Usuario> findByCorreo(String correo);

    Page<Usuario> findAll(Pageable pageable);

    @Query("select r from Usuario u, IN(u.reservas) r where u.correo = :email")
    List<Reserva> obtenerListaReservas(String email);

  //  @Query("select new co.edu.uniquindio.unitravel.dto.ComentarioDTO(u.correo, c) from Usuario u left join u.comentarios c")
  //  List<ComentarioDTO> obtenerComentario();

    @Query("select u, r from Usuario u left join u.reservas r")
    List< Object[] > obtenerReservasTotales();

    @Query("select distinct t from Usuario u join u.telefono t")
    List<String> obtenerUsuariosTelefono();
}
