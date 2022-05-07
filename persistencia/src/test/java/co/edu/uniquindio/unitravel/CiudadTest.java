package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrarCiudad()
    {
        Ciudad ciudad = new Ciudad("Madrid");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        Assertions.assertNotNull(ciudadGuardada);
    }

    @Test
    public void eliminarCiudad()
    {
        Ciudad ciudad = new Ciudad("Madrid");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        ciudadRepo.delete(ciudadGuardada);

        boolean ciudadBuscada = ciudadRepo.equals("Madrid");
        Assertions.assertTrue(ciudadBuscada);
    }

    @Test
    public void actualizarCiudadTest()
    {
        Ciudad ciudad = new Ciudad("Bogotá");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        ciudadGuardada.setNombre("Tokyo");

        ciudadRepo.save(ciudadGuardada);
    }

    @Test
    //@Sql("classpath:hotel.sql")
    public void listarCiurTest()
    {
        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println(lista);
    }
}
