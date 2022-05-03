package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    //@JoinColumn(nullable = false)
    private Reserva reserva;

    @ManyToOne
    //@JoinColumn(nullable = false)
    private Silla silla;

    public ReservaSilla(Double precio, Reserva reserva, Silla silla) {
        this.precio = precio;
        this.reserva = reserva;
        this.silla = silla;
    }
}
