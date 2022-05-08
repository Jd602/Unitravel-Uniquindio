package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.EstadoHabitacion;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabitacionTest {


    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    public void registrar()
    {
        Habitacion habitacion = new Habitacion("A201",140000.00,2,EstadoHabitacion.DISPONIBLE);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        Assertions.assertNotNull(habitacionGuardada);
    }

    @Test
    public void eliminarHabitacionTest()
    {
        Habitacion habitacion = new Habitacion("A201",140000.00,2,EstadoHabitacion.DISPONIBLE);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        habitacionRepo.delete(habitacionGuardada);

        Habitacion habitacionbuscada = habitacionRepo.findById("A201").orElse(null);
        Assertions.assertNull(habitacionbuscada);
    }

    @Test
    public void actualizarHabitacionTest()
    {
        Habitacion habitacion = new Habitacion("A115", 190000.00, 3, EstadoHabitacion.DISPONIBLE);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        habitacionGuardada.setEstado(EstadoHabitacion.NO_DISPONIBLE);

        habitacionRepo.save(habitacionGuardada);

        Habitacion habitacionbuscada = habitacionRepo.findById("A115").orElse(null);
        Assertions.assertEquals(EstadoHabitacion.NO_DISPONIBLE, habitacionbuscada.getEstado());
    }

    @Test
    @Sql("classpath:habitacion.sql")
    public void listarHabitacionTest()
    {
        List<Habitacion> lista = habitacionRepo.findAll();
        System.out.println(lista);
    }
}
