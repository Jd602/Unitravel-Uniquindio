package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.EstadoReserva;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    public void registrar()
    {
        Usuario u = new Usuario("ecs23","nom","aaa@gmail.com","123");
        LocalDate f = LocalDate.parse("2022-05-02");
        LocalDate f1 = LocalDate.parse("2022-05-09");
        LocalDate f2 = LocalDate.parse("2022-05-11");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.CONFIRMADA,184000.00,1,u);
        Reserva reservaGuardada = reservaRepo.save(reserva);

        Assertions.assertNotNull(reservaGuardada);
    }

    @Test
    public void eliminarReservaTest()
    {
        Usuario u2 = new Usuario("4435","nom2","aaa2@gmail.com","123");
        LocalDate f = LocalDate.parse("2022-05-06");
        LocalDate f1 = LocalDate.parse("2022-05-07");
        LocalDate f2 = LocalDate.parse("2022-05-10");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.PENDIENTE_DE_PAGO,300000.00,2,u2);
        Reserva reservaGuardada = reservaRepo.save(reserva);
        int c = reservaGuardada.getCodigo();

        reservaRepo.delete(reservaGuardada);

        Reserva reservabuscado = reservaRepo.findById(c).orElse(null);
        Assertions.assertNull(reservabuscado);
    }

    @Test
    public void actualizarReservaTest()
    {
        Usuario u3 = new Usuario("223635","nom3","aaa3@gmail.com","123");
        LocalDate f = LocalDate.parse("2022-05-06");
        LocalDate f1 = LocalDate.parse("2022-05-06");
        LocalDate f2 = LocalDate.parse("2022-05-08");
        Reserva reserva = new Reserva(f,f1,f2,
                EstadoReserva.PENDIENTE_DE_PAGO,250000.00,1,u3);
        Reserva reservaGuardada = reservaRepo.save(reserva);
        int c2 = reservaGuardada.getCodigo();

        reservaGuardada.setPrecioTotal(240000.00);

        reservaRepo.save(reservaGuardada);

        Reserva reservabuscado = reservaRepo.findById(c2).orElse(null);
        Assertions.assertEquals(240000.00, reservabuscado.getPrecioTotal());
    }

    @Test
    //@Sql("classpath:registros.sql")
    public void listarReservasTest()
    {
        List<Reserva> lista = reservaRepo.findAll();
        System.out.println(lista);
    }

}
