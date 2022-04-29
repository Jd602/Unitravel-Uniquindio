package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private Double precio;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Reserva reserva;

    @JoinColumn(nullable = false)

    @ManyToOne
    private Silla silla;

    public ReservaSilla(Double precio, Reserva reserva, Silla silla) {
        this.precio = precio;
        this.reserva = reserva;
        this.silla = silla;
    }
}
