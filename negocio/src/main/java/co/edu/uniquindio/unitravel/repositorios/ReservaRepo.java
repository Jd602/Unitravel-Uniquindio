package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.ReservaDTO;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva,Integer> {

    @Query("select new co.edu.uniquindio.unitravel.dto.ReservaDTO(r.reserva.usuario.nombre, r.reserva.fecha, h.hotel.nombre)" +
            "from ReservaHabitacion r join r.habitacion h where h.hotel.codigo=:idHotel and r.reserva.fechaInicio<:fechaReserva")
    List<ReservaDTO[]> obtenerReservas(Integer idHotel, LocalDate fechaReserva);

}
