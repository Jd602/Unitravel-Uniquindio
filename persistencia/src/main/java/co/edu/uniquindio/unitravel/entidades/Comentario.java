package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String contenido;

    @JoinColumn(nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Estrella calificacion;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private LocalDate fecha;

    @ManyToOne
    @EqualsAndHashCode.Include
    @ToString.Include
    private Hotel hotel;

    @ManyToOne
    @EqualsAndHashCode.Include
    @ToString.Include
    private Usuario usuario;

    public Comentario(String contenido, Estrella calificacion, LocalDate fecha, Hotel hotel, Usuario usuario) {
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.hotel = hotel;
        this.usuario = usuario;
    }
}
