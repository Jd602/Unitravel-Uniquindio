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
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false,length = 5,unique = true)
    private String posicion;

    @Column(nullable = false,precision = 8,scale = 2)
    private Double precio;


    @OneToMany(mappedBy = "silla")
    //@JoinColumn(nullable = false)
    private List<ReservaSilla> reservasSilla;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vuelo vuelo;

    public Silla(String posicion, Double precio, List<ReservaSilla> reservasSilla, Vuelo vuelo) {
        this.posicion = posicion;
        this.precio = precio;
        this.reservasSilla = reservasSilla;
        this.vuelo = vuelo;
    }
}
