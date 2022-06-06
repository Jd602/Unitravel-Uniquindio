package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.EstadoVuelo;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrar()
    {
        Ciudad c1 = new Ciudad("Uno");
        Ciudad c2 = new Ciudad("Dos");
        ciudadRepo.save(c1);
        ciudadRepo.save(c2);
        Vuelo vuelo = new Vuelo(EstadoVuelo.ABORDED, "Avianca", c1, c2);
        Vuelo vueloGuardado = vueloRepo.save(vuelo);

        Assertions.assertNotNull(vueloGuardado);
    }

    @Test
    public void eliminarVueloTest()
    {
        Ciudad c1 = new Ciudad("Uno");
        Ciudad c2 = new Ciudad("Dos");
        ciudadRepo.save(c1);
        ciudadRepo.save(c2);
        Vuelo vuelo = new Vuelo(EstadoVuelo.DELAYED, "EasyFly", c2, c1);
        Vuelo vueloGuardado = vueloRepo.save(vuelo);

        vueloRepo.delete(vueloGuardado);

        Vuelo vuelobuscado = vueloRepo.findById(vueloGuardado.getCodigo()).orElse(null);
        Assertions.assertNull(vuelobuscado);
    }

    @Test
    public void actualizarUsuarioTest()
    {
        Ciudad c1 = new Ciudad("Uno");
        Ciudad c2 = new Ciudad("Dos");
        ciudadRepo.save(c1);
        ciudadRepo.save(c2);
        Vuelo vuelo = new Vuelo(EstadoVuelo.DELAYED, "LAN", c1, c2);
        Vuelo vueloGuardado = vueloRepo.save(vuelo);

        vueloGuardado.setAerolinea("Avianca");

        vueloRepo.save(vueloGuardado);
        vueloGuardado.setCodigo(1);

        Vuelo vuelobuscado = vueloRepo.findById(1).orElse(null);
        //Assertions.assertEquals("Avianca", vuelobuscado.getAerolinea());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarVueloTest()
    {
        List<Vuelo> lista = vueloRepo.findAll();
        System.out.println(lista);
    }

}
