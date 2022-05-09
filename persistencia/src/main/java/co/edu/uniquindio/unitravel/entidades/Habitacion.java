package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    @Column(length = 5)
    @ToString.Include
    private String numero;

    @Column(precision = 8,scale = 2,nullable = false)
    @ToString.Include
    private Double precio;

    @Min(1)
    @Max(8)
    @Column(nullable = false)
    @ToString.Include
    private int capacidad;


    @ToString.Include
    @JoinColumn(nullable = false)
    private EstadoHabitacion estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @ManyToMany
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "habitacion")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> reservas;

    @ManyToMany(mappedBy = "habitaciones")
    private List<Cama> camas;

    public Habitacion(String numero, Double precio, int capacidad, EstadoHabitacion estado,Hotel hotel) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
        this.estado = estado;
        this.hotel = hotel;
    }
}
