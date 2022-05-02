package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Map;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length=15,updatable = false)
    private String cedula;

    @Column (length=100,updatable = false,nullable = false)
    private String nombre;

    @Email
    @Column (length=50,unique = true,nullable = false)
    private String correo;

    @Column(length=12,nullable = false)
    private String password;

    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> telefono;

    public Persona(String cedula, String nombre, String correo,String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

}
