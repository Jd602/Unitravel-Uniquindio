package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {
}
