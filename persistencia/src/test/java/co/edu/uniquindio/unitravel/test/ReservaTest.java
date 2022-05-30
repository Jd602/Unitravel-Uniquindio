package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;


    @Test
    public void registrar()
    {
        Usuario u = insertarUsuario();
        LocalDate f = LocalDate.parse("2022-05-02");
        LocalDate f1 = LocalDate.parse("2022-06-09");
        LocalDate f2 = LocalDate.parse("2022-06-11");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.CONFIRMADA,184000.00,1,u);
        Reserva reservaGuardada = reservaRepo.save(reserva);

        Assertions.assertNotNull(reservaGuardada);
    }

    @Test
    public void eliminarReservaTest()
    {
        Usuario u2 = insertarUsuario();
        LocalDate f = LocalDate.parse("2022-05-06");
        LocalDate f1 = LocalDate.parse("2022-06-07");
        LocalDate f2 = LocalDate.parse("2022-06-10");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.PENDIENTE_DE_PAGO,300000.00,2,u2);
        reserva.setCodigo(1);
        Reserva reservaGuardada = reservaRepo.save(reserva);

        reservaRepo.delete(reservaGuardada);

        Reserva reservabuscado = reservaRepo.findById(1).orElse(null);
        Assertions.assertNull(reservabuscado);
    }

    @Test
    public void actualizarReservaTest()
    {
        Usuario u3 = insertarUsuario();
        LocalDate f = LocalDate.parse("2022-05-06");
        LocalDate f1 = LocalDate.parse("2022-06-06");
        LocalDate f2 = LocalDate.parse("2022-06-08");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.PENDIENTE_DE_PAGO,250000.00,1,u3);
        Reserva reservaGuardada = reservaRepo.save(reserva);
        reservaGuardada.setCodigo(1);

        reservaGuardada.setPrecioTotal(240000.00);

        reservaRepo.save(reservaGuardada);


        Reserva reservabuscado = reservaRepo.findById(1).orElse(null);
        System.out.println(reservaRepo.toString());


        //Assertions.assertEquals(240000.00,reservabuscado.getPrecioTotal());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarReservasTest()
    {
        List<Reserva> lista = reservaRepo.findAll();
        System.out.println(lista);
    }

    @Test
    public Usuario insertarUsuario()
    {
        Usuario user = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com",
                "123456");
        usuarioRepo.save(user);

        return user;
    }
}
