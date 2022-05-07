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
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @Column(nullable = false,length = 30)
    @ToString.Include
    private String nombre;

    @Column(length = 60,nullable = false)
    @ToString.Include
    private String direccion;

    @JoinColumn(nullable = false)
    @ToString.Include
    private Estrella numEstrellas;

    @ManyToOne
    @JoinColumn(nullable = true)
    private AdminHotel administrador;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    private List<Foto> fotos;

    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    private List<Comentario> comentarios;

    public Hotel(String nombre, String direccion, Estrella numEstrellas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEstrellas = numEstrellas;
    }
}
