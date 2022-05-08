package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.FotoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FotoTest {

    @Autowired
    private FotoRepo fotoRepo;

    @Test
    public void registrarFotoTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS);
        Habitacion habitacion = new Habitacion("A201",140000.00,2, EstadoHabitacion.DISPONIBLE);

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        Assertions.assertNotNull(fotoGuardado);
    }

    @Test
    public void eliminarFotoTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS);
        Habitacion habitacion = new Habitacion("A201",140000.00,2, EstadoHabitacion.DISPONIBLE);

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        fotoRepo.delete(foto);
    }

    @Test
    public void actualizarFotoTest()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS);
        Habitacion habitacion = new Habitacion("A201",140000.00,2, EstadoHabitacion.DISPONIBLE);

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        fotoGuardado.setUrl("");

        fotoRepo.save(fotoGuardado);

    }

    @Test
    @Sql("classpath:foto.sql")
    public void listarFotoTest()
    {
        List<Foto> lista = fotoRepo.findAll();
        System.out.println(lista);
    }
}
