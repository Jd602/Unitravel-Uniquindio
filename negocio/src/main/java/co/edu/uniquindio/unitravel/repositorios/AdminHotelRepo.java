package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminHotelRepo extends JpaRepository<AdminHotel, String> {

    Optional<AdminHotel> findByCorreo(String correo);

    Optional<AdminHotel> findByCorreoAndPassword(String correo, String password);
}
