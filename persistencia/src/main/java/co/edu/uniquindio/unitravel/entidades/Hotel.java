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
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false,length = 30)
    private String nombre;

    @Column(length = 60,nullable = false)
    private String direccion;

    @JoinColumn(nullable = false)
    private Estrella numEstrellas;

    @ManyToOne
    @JoinColumn(nullable = false)
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

    public Hotel(String nombre, String direccion, Estrella numEstrellas, AdminHotel administrador,
                 Ciudad ciudad, List<Foto> fotos, List<Caracteristica> caracteristicas,
                 List<Habitacion> habitaciones, List<Comentario> comentarios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEstrellas = numEstrellas;
        this.administrador = administrador;
        this.ciudad = ciudad;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.habitaciones = habitaciones;
        this.comentarios = comentarios;
    }
}
