package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class ReservaHabitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(precision = 8,scale = 2,nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Habitacion habitacion;

    public ReservaHabitacion(Double precio, Reserva reserva, Habitacion habitacion) {
        this.precio = precio;
        this.reserva = reserva;
        this.habitacion = habitacion;
    }
}
