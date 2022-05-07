package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length =30 )
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany
    private List<Hotel> hoteles;

    @ManyToMany
    private List<Habitacion> habitaciones;

    public Caracteristica(String nombre, String descripcion, List<Hotel> hoteles, List<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hoteles = hoteles;
        this.habitaciones = habitaciones;
    }
}
