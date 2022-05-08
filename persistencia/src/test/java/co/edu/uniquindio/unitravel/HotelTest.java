package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Estrella;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    public void registrarHotel()
    {
        Hotel hotel = new Hotel("hotel1", "calle 1", Estrella.DOS_ESTRELLAS);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        Assertions.assertNotNull(hotelGuardado);
    }

    @Test
    public void eliminarHotel()
    {
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        hotelRepo.delete(hotelGuardado);

        boolean hotelBuscado = hotelRepo.equals("Madrid");
        Assertions.assertTrue(hotelBuscado);
    }

    @Test
    public void actualizarHotelTest()
    {
        Hotel hotel = new Hotel("Atlanta","",Estrella.UNA_ESTRELLA);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        hotelGuardado.setNombre("Atlanta");

        hotelRepo.save(hotelGuardado);
    }

    @Test
    @Sql("classpath:hotel.sql")
    public void listarHotelTest()
    {
        List<Hotel> lista = hotelRepo.findAll();
        System.out.println(lista);
    }
}
