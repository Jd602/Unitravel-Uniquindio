package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdminHotel extends Persona implements Serializable {

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = true)
    private LocalDate fechaRetiro;

    @Column(nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "administrador")
    //@JoinColumn(nullable = false)
    private List<Hotel> hoteles;

    public AdminHotel(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
