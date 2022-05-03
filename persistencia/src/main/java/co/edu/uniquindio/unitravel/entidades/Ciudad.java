package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(length=30,nullable=false)
    private String nombre;

    @OneToMany(mappedBy ="ciudad" )
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "origen,destino")
    private List<Vuelo> vuelos;

    public Ciudad(String nombre, List<Usuario> usuarios, List<Hotel> hoteles, List<Vuelo> vuelos) {
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.hoteles = hoteles;
        this.vuelos = vuelos;
    }
}
