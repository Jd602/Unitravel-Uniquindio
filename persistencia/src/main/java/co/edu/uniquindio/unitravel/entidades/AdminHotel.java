package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true,onlyExplicitlyIncluded = true)
public class AdminHotel extends Persona implements Serializable {

    @Column(nullable = true)
    private LocalDate fechaIngreso;

    @Column(nullable = true)
    private LocalDate fechaRetiro;

    @Column(nullable = true)
    @ToString.Include
    private Estado estado;

    @OneToMany(mappedBy = "administrador")
    private List<Hotel> hoteles;

    public AdminHotel(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
