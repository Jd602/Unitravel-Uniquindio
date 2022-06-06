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
@ToString(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @Column(length=30 )
    @ToString.Include
    private String nombre;

    @Column(nullable = false)
    @ToString.Include
    private String descripcion;

    @ManyToMany
    private List<Hotel> hoteles;

    @ManyToMany
    private List<Habitacion> habitaciones;

    public Caracteristica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
