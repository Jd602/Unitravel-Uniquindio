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
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false,length = 5,unique = true)
    private String posicion;

    @Column(nullable = false)
    private Double precio;


    @OneToMany(mappedBy = "silla")
    //@JoinColumn(nullable = false)
    private List<ReservaSilla> reservasSilla;

    @ManyToOne
    private Vuelo vuelo;

    public Silla(String posicion, Double precio, List<ReservaSilla> reservasSilla, Vuelo vuelo) {
        this.posicion = posicion;
        this.precio = precio;
        this.reservasSilla = reservasSilla;
        this.vuelo = vuelo;
    }
}
