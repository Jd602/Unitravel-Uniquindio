package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    //@Column(nullable = false)
    private LocalDate fechaIngreso;

    //@Column(nullable = false)
    private LocalDate fechaRetiro;

    //@Column(nullable = false)
    private Estado estado;

    public Administrador(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
