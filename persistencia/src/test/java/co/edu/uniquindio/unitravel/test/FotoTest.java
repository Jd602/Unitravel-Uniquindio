package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
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
    @Autowired
    private AdminHotelRepo adminHotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private HabitacionRepo habitacionRepo;


    @Test
    public void registrarFotoTest()
    {
       Habitacion habitacion=insertarHabitacion();
       Hotel hotel = habitacion.getHotel();

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        Assertions.assertNotNull(fotoGuardado);
    }

    @Test
    public void eliminarFotoTest()
    {
        Habitacion habitacion=insertarHabitacion();
        Hotel hotel = habitacion.getHotel();

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        fotoRepo.delete(foto);
    }

    @Test
    public void actualizarFotoTest()
    {
        Habitacion habitacion=insertarHabitacion();
        Hotel hotel = habitacion.getHotel();

        Foto foto = new Foto("https://media-cdn.tripadvisor.com/media/photo-s/16/1a/ea/54/hotel-presidente-4s.jpg",
                hotel, habitacion);

        Foto fotoGuardado = fotoRepo.save(foto);

        fotoGuardado.setUrl("");

        fotoRepo.save(fotoGuardado);

    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarFotoTest()
    {
        List<Foto> lista = fotoRepo.findAll();
        System.out.println(lista);
    }

    @Test
    public Habitacion insertarHabitacion()
    {
        AdminHotel adm =new AdminHotel("11","admin","admin@hotmail.com","123");
        adminHotelRepo.save(adm);
        Ciudad ciudad = new Ciudad("city");
        ciudadRepo.save(ciudad);
        Hotel hotel = new Hotel("Madrid","calle 2", Estrella.CUATRO_ESTRELLAS,adm,ciudad);
        hotelRepo.save(hotel);
        Habitacion room = new Habitacion("A202",90000.00,4,EstadoHabitacion.DISPONIBLE,hotel);
        habitacionRepo.save(room);

        return room;
    }

}
