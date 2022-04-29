package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    public Usuario(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
