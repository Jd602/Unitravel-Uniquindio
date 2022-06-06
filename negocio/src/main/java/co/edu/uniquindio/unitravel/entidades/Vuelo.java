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
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;


    @JoinColumn(nullable = false)
    @ToString.Include
    private EstadoVuelo estado;


    @Column(nullable = false,length = 30)
    @ToString.Include
    private String aerolinea;

    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Include
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Include
    private Ciudad destino;

    public Vuelo(EstadoVuelo estado, String aerolinea,  Ciudad origen, Ciudad destino) {
        this.estado = estado;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
    }
}
