package co.edu.uniquindio.unitravel.dto;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ReservaDTO {

    private String nombreUsuario;
    private LocalDate fechaReserva;
    private String nombreHotel;
}
