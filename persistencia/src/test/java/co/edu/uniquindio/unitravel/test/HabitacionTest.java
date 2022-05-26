package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.*;
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
        AdminHotel adm1 =new AdminHotel("111","admin1","admin1@hotmail.com","123");
        Ciudad ciudad1 = new Ciudad("city1");
        Hotel hotel1= new Hotel("hotel1","dir hotel", Estrella.DOS_ESTRELLAS,adm1,ciudad1);
        Habitacion habitacion = new Habitacion("A201",140000.00,2,
                EstadoHabitacion.DISPONIBLE,hotel1);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        Assertions.assertNotNull(habitacionGuardada);
    }

    @Test
    public void eliminarHabitacionTest()
    {
        AdminHotel adm2 =new AdminHotel("112","admin2","admin2@hotmail.com","123");
        Ciudad ciudad2 = new Ciudad("city2");
        Hotel hotel2= new Hotel("hotel2","dir hotel", Estrella.DOS_ESTRELLAS,adm2,ciudad2);
        Habitacion habitacion = new Habitacion("A201",140000.00,2,
                EstadoHabitacion.DISPONIBLE,hotel2);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        habitacionRepo.delete(habitacionGuardada);

        Habitacion habitacionbuscada = habitacionRepo.findById("A201").orElse(null);
        Assertions.assertNull(habitacionbuscada);
    }

    @Test
    public void actualizarHabitacionTest()
    {
        AdminHotel adm3 =new AdminHotel("113","admin3","admin3@hotmail.com","123");
        Ciudad ciudad3 = new Ciudad("city3");
        Hotel hotel3= new Hotel("hotel3","dir hotel", Estrella.TRES_ESTRELLAS,adm3,ciudad3);
        Habitacion habitacion = new Habitacion("A115", 190000.00, 3,
                EstadoHabitacion.DISPONIBLE,hotel3);
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        habitacionGuardada.setEstado(EstadoHabitacion.NO_DISPONIBLE);

        habitacionRepo.save(habitacionGuardada);

        Habitacion habitacionbuscada = habitacionRepo.findById("A115").orElse(null);
        Assertions.assertEquals(EstadoHabitacion.NO_DISPONIBLE, habitacionbuscada.getEstado());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarHabitacionTest()
    {
        List<Habitacion> lista = habitacionRepo.findAll();
        System.out.println(lista);
    }
}
