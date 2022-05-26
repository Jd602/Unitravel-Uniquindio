package co.edu.uniquindio.unitravel.test;

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

import javax.persistence.Transient;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;
    private AdminHotel adm =new AdminHotel("11","admin","admin@hotmail.com","123");
    private Ciudad ciudad = new Ciudad("city");

    @Test
    public void registrarHotel()
    {
        AdminHotel adm =new AdminHotel("11","admin1","admin1@hotmail.com","123");
        Ciudad ciudad = new Ciudad("city1");
        Hotel hotel = new Hotel("hotel1", "calle 1", Estrella.DOS_ESTRELLAS,adm,ciudad);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        Assertions.assertNotNull(hotelGuardado);
    }

    @Test
    public void eliminarHotel()
    {
        AdminHotel adm =new AdminHotel("112","admin2","admin2@hotmail.com","123");
        Ciudad ciudad = new Ciudad("city2");
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        hotelRepo.delete(hotelGuardado);

        boolean hotelBuscado = hotelRepo.equals("Madrid");
        Assertions.assertTrue(hotelBuscado);
    }

    @Test
    public void actualizarHotelTest()
    {
        AdminHotel adm =new AdminHotel("113","admin3","admin3@hotmail.com","123");
        Ciudad ciudad = new Ciudad("city3");
        Hotel hotel = new Hotel("Atlanta","",Estrella.UNA_ESTRELLA,adm,ciudad);
        Hotel hotelGuardado = hotelRepo.save(hotel);

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
