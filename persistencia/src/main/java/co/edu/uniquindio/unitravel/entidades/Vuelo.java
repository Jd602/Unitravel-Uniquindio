package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;


    @JoinColumn(nullable = false)
    private EstadoVuelo estado;


    @Column(nullable = false,length = 30,unique = true)
    private String aerolinea;

    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

    public Vuelo(EstadoVuelo estado, String aerolinea, List<Silla> sillas) {
        this.estado = estado;
        this.aerolinea = aerolinea;
        this.sillas = sillas;
    }
}
