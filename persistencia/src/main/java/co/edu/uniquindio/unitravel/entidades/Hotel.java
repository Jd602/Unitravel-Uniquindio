package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(nullable = false,length = 30)
    private String nombre;

    @Column(length = 60,nullable = false)
    private String direccion;

    @JoinColumn(nullable = false)
    private Estrella numEstrellas;

    @ManyToOne
    private AdminHotel administrador;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "fotos")
    private List<Foto> fotos;

    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    private List<Comentario> comentarios;

    public Hotel(String nombre, String direccion, Estrella numEstrellas, AdminHotel administrador, Ciudad ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEstrellas = numEstrellas;
        this.administrador = administrador;
        this.ciudad = ciudad;
    }
}
