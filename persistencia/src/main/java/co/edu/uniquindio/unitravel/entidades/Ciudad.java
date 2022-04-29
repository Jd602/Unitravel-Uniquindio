package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

@Entity
@NoArgsConstructor
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

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}
