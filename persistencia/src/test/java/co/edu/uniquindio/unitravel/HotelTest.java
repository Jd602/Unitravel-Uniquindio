package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
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
        AdminHotel adm =new AdminHotel("11","admin","admin@hotmail.com","123");
        Ciudad ciudad1 = new Ciudad("city");
        Hotel hotel1 = new Hotel("hotel 1", "calle 1", Estrella.DOS_ESTRELLAS,adm,ciudad1);
        Hotel hotelGuardado = hotelRepo.save(hotel1);

        Assertions.assertNotNull(hotelGuardado);
    }

    @Test
    public void eliminarHotel()
    {
        AdminHotel adm =new AdminHotel("112","admin2","admin2@hotmail.com","123");
        Ciudad ciudad2 = new Ciudad("city2");
        Hotel hotel2 = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad2);
        Hotel hotelGuardado = hotelRepo.save(hotel2);

        hotelRepo.delete(hotelGuardado);

        boolean hotelBuscado = hotelRepo.equals("Madrid");
        Assertions.assertTrue(hotelBuscado);
    }

    @Test
    public void actualizarHotelTest()
    {
        AdminHotel adm =new AdminHotel("113","admrin","admrin@hotmail.com","123");
        Ciudad ciudad3 = new Ciudad("city3");
        Hotel hotel3 = new Hotel("Atlanta","",Estrella.UNA_ESTRELLA,adm,ciudad3);
        Hotel hotelGuardado = hotelRepo.save(hotel3);

        hotelGuardado.setNombre("Atlanta");

        hotelRepo.save(hotelGuardado);
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarHotelTest()
    {
        List<Hotel> lista = hotelRepo.findAll();
        System.out.println(lista);
    }
}
