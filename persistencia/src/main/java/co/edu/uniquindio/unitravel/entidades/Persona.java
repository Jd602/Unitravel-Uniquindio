package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;



@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length=15,updatable = false)
    private String cedula;

    @Column (length=50,updatable = false,nullable = false)
    private String nombre;

    @Email
    @Column (length=30,unique = true,nullable = false)
    private String correo;

    @Column(length=10,nullable = false)
    private String password;

    @ElementCollection
    @Column(nullable = true)
    private List<String> telefono;

    public Persona(String cedula, String nombre, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
}
