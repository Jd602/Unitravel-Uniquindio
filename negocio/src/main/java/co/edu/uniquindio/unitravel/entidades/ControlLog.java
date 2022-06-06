package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class ControlLog implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private int idRegistro;
    @Column(nullable = false,length = 50)
    @ToString.Include
    private String user;
    @Column(nullable = false,length = 15)
    @ToString.Include
    private String idUser;
    @Column(nullable=false)
    @ToString.Include
    private LocalDate fecha;
    @Column(nullable = false)
    @ToString.Include
    private String message;

}
