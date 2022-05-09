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
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private int codigo;

    @Column(nullable = false,length = 5,unique = true)
    @ToString.Include
    private String posicion;

    @Column(nullable = false,precision = 8,scale = 2)
    @ToString.Include
    private Double precio;


    @OneToMany(mappedBy = "silla")
    //@JoinColumn(nullable = true)
    private List<ReservaSilla> reservasSilla;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Include
    private Vuelo vuelo;

    public Silla(String posicion, Double precio, Vuelo vuelo) {
        this.posicion = posicion;
        this.precio = precio;
        this.vuelo = vuelo;
    }
}
