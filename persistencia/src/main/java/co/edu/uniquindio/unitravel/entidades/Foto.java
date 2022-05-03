package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false,unique = true)
    private String url;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Habitacion habitacion;

    public Foto(String url, Hotel hotel, Habitacion habitacion) {
        this.url = url;
        this.hotel = hotel;
        this.habitacion = habitacion;
    }
}
