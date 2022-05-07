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

    @Column(nullable = true)
    private LocalDate fechaIngreso;

    @Column(nullable = true)
    private LocalDate fechaRetiro;

    @Column(nullable = true)
    private Estado estado;

    public Administrador(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
