package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = true)
    private LocalDate fechaRetiro;

    @Column(nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    public Administrador(String cedula, String nombre, String correo, String password,
                         LocalDate fechaIngreso, Estado estado) {
        super(cedula, nombre, correo, password);
        this.fechaIngreso=fechaIngreso;
        this.estado=estado;
    }
}
