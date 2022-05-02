package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDate fecha;

    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Future
    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private EstadoReserva estado;

    private Double precioTotal;

    @Column(nullable=false)
    private int cantidadPersonas;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "reserva")
    @JoinColumn(nullable = false)
    private List<ReservaSilla> reservasSilla;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaHabitacion> reservas;

    public Reserva(LocalDate fecha, LocalDate fechaInicio, LocalDate fechaFin, EstadoReserva estado,
                   int cantidadPersonas, Usuario usuario) {
        this.fecha = fecha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.cantidadPersonas = cantidadPersonas;
        this.usuario = usuario;
    }
}
