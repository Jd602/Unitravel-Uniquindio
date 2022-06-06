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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private int id;

    @EqualsAndHashCode.Include
    @Column(length=30,nullable=false)
    @ToString.Include
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "origen")
    private List<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "destino")
    private List<Vuelo> vuelosDestino;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}
