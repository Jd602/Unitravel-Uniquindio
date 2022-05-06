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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @EqualsAndHashCode.Include
    @Column(length=30,nullable=false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "origen")
    private List<Vuelo> vuelos;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}
