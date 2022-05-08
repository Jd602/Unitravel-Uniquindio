package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.EstadoHabitacion;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaracteristicaTest {

    CaracteristicaRepo caracteristicaRepo;

    @Test
    public void registrarCaracteristicaTest()
    {
        Caracteristica caracteristica = new Caracteristica("Aire acondicionado",
                "Importante para mejorar la experiencia");
        Caracteristica caracteristicaGuardada = caracteristicaRepo.save(caracteristica);

        Assertions.assertNotNull(caracteristicaGuardada);
    }

    @Test
    public void eliminaCaracteristicaTest()
    {
        Caracteristica caracteristica = new Caracteristica("Aire acondicionado",
                "Importante para mejorar la experiencia");
        Caracteristica caracteristicaGuardada = caracteristicaRepo.save(caracteristica);

        caracteristicaRepo.delete(caracteristicaGuardada);

    }

    @Test
    public void actualizarHabitacionTest()
    {
        Caracteristica caracteristica = new Caracteristica("Aire acondicionado",
                "Importante para mejorar la experiencia");
        Caracteristica caracteristicaGuardada = caracteristicaRepo.save(caracteristica);

        caracteristica.setNombre("Jacuzzi");
        caracteristica.setDescripcion("Perfecto para disfrutar en pareja");

        caracteristicaRepo.save(caracteristica);
    }

    @Test
    @Sql("classpath:caracteristica.sql")
    public void listarCaracteristicaTest()
    {
        List<Caracteristica> lista = caracteristicaRepo.findAll();
        System.out.println(lista);
    }
}
