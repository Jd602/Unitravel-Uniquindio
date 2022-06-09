package co.edu.uniquindio.unitravel.config;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class InformacionPorDefecto implements CommandLineRunner {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private CaracterirsticaServicio caracterirsticaServicio;


    @Override
    public void run(String... args) throws Exception{

        if (administradorServicio.listarAdmins().isEmpty()) {

            Administrador administrador = new Administrador("1234", "Juan", "juan@gmail.com", "1234");
            administradorServicio.registrarAdmin(administrador);

            Ciudad ciudad1 = new Ciudad("Bogotá");
            Ciudad ciudad2 = new Ciudad("San Andrés");
            Ciudad ciudad3 = new Ciudad("Medellin");
            Ciudad ciudad4 = new Ciudad("Cali");
            Ciudad ciudad5 = new Ciudad("Barranquilla");
            Ciudad ciudad6 = new Ciudad("Pereira");
            Ciudad ciudad7 = new Ciudad("Armenia");
            Ciudad ciudad8 = new Ciudad("Manizales");
            Ciudad ciudad9 = new Ciudad("Ibagué");
            Ciudad ciudad10 = new Ciudad("Cartagena");

            administradorServicio.registrarCiudad(ciudad1);
            administradorServicio.registrarCiudad(ciudad2);
            administradorServicio.registrarCiudad(ciudad3);
            administradorServicio.registrarCiudad(ciudad4);
            administradorServicio.registrarCiudad(ciudad5);
            administradorServicio.registrarCiudad(ciudad6);
            administradorServicio.registrarCiudad(ciudad7);
            administradorServicio.registrarCiudad(ciudad8);
            administradorServicio.registrarCiudad(ciudad9);
            administradorServicio.registrarCiudad(ciudad10);

            AdministradorHotel gerente1 = new AdministradorHotel("1234a","Caro","caro@gmail.com","1234");
            administradorServicio.registrarAdminHotel(gerente1);
            AdministradorHotel gerente2 = new AdministradorHotel("1234b","David","david@gmail.com","1234");
            administradorServicio.registrarAdminHotel(gerente2);

            Cama cama = new Cama("Doble");
            Cama cama1 = new Cama("Sencilla");

            administradorHotelServicio.crearCama(cama);
            administradorHotelServicio.crearCama(cama1);


            Caracteristica caracteristica = new Caracteristica("Muy cómoda",2);
            Caracteristica caracteristica1 = new Caracteristica("Estándar",2);

            Caracteristica caracteristica2 = new Caracteristica("Básico",1);
            Caracteristica caracteristica3 = new Caracteristica("Nivel Medio",1);

            caracterirsticaServicio.crearCaracteristica(caracteristica);
            caracterirsticaServicio.crearCaracteristica(caracteristica1);
            caracterirsticaServicio.crearCaracteristica(caracteristica2);
            caracterirsticaServicio.crearCaracteristica(caracteristica3);

            Hotel hotel1 = new Hotel("Atlantis","Km 24 via Aeropuerto","3002345",5,gerente1,ciudad1);
            hotel1.setDescripcion("Cerca al aeropuerto");
            Hotel hotel2 = new Hotel("Estelar","Calle Real plaza vieja","20563",3,gerente2,ciudad2);
            hotel2.setDescripcion("En el centro de la isla");
            Hotel hotel3 = new Hotel("Brisa de Mar>","Playa Castillo Km2","34844",4,gerente2,ciudad5);
            hotel3.setDescripcion("Frente al mar caribe");


            Habitacion habitacion1 = new Habitacion(600000.00,3,hotel1);
            Habitacion habitacion2 = new Habitacion(500000.00,2,hotel1);
            Habitacion habitacion3 = new Habitacion(120000.00,1,hotel2);
            Habitacion habitacion4 = new Habitacion(350000.00,4,hotel2);
            Habitacion habitacion5 = new Habitacion(400000.00,2,hotel3);
            Habitacion habitacion6 = new Habitacion(400000.00,2,hotel3);

            ArrayList <Habitacion> habitaciones1 =  new ArrayList<Habitacion>();
            habitaciones1.add(habitacion1);
            habitaciones1.add(habitacion2);
            hotel1.setHabitaciones(habitaciones1);

            ArrayList <Habitacion> habitaciones2 =  new ArrayList<Habitacion>();
            habitaciones2.add(habitacion3);
            habitaciones2.add(habitacion4);
            hotel1.setHabitaciones(habitaciones2);

            ArrayList <Habitacion> habitaciones3 =  new ArrayList<Habitacion>();
            habitaciones3.add(habitacion5);
            habitaciones3.add(habitacion6);
            hotel1.setHabitaciones(habitaciones3);

            administradorHotelServicio.crearHotel(hotel1);
            administradorHotelServicio.crearHotel(hotel2);
            administradorHotelServicio.crearHotel(hotel3);



        }
    }
}
