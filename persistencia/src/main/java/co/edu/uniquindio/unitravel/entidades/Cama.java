package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private TipoCama tipo;

    @ManyToMany
    @JoinColumn(nullable = false)
    private List<Habitacion> habitaciones;

    public Cama(int codigo, TipoCama tipo, List<Habitacion> habitaciones) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.habitaciones = habitaciones;
    }
}
