package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    public Usuario(String cedula, String nombre, @Email String correo, String password,
                   Map<String, String> telefono, Ciudad ciudad, List<Reserva> reservas,
                   List<Comentario> comentarios) {
        super(cedula, nombre, correo, password, telefono);
        this.ciudad = ciudad;
        this.reservas = reservas;
        this.comentarios = comentarios;
    }
}
