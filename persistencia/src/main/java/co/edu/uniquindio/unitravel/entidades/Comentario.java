package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String contenido;

    @JoinColumn(nullable = false)
    private Estrella calificacion;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Usuario usuario;

    public Comentario(String contenido, Estrella calificacion, LocalDate fecha, Hotel hotel, Usuario usuario) {
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.hotel = hotel;
        this.usuario = usuario;
    }
}
