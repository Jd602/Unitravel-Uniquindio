package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.SillaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SillaTest {

    @Autowired
    private SillaRepo sillaRepo;

    @Test
    public void registrar()
    {
        Ciudad c1 = new Ciudad("city1");
        Ciudad c2 = new Ciudad("city2");
        Vuelo v = new Vuelo(EstadoVuelo.ABORDED,"LAN",c1,c2);
        Silla silla = new Silla("A32P",137000.00,v);
        Silla sillaGuardada = sillaRepo.save(silla);

        Assertions.assertNotNull(sillaGuardada);
    }

    @Test
    public void eliminarUsuarioTest()
    {
        Ciudad c1 = new Ciudad("city1");
        Ciudad c2 = new Ciudad("city2");
        Vuelo v = new Vuelo(EstadoVuelo.ABORDED,"LAN",c1,c2);
        Silla silla = new Silla("A60P",370000.00,v);
        Silla sillaGuardada = sillaRepo.save(silla);
        int c = sillaGuardada.getCodigo();

        sillaRepo.delete(sillaGuardada);

        Silla adminHotelbuscado = sillaRepo.findById(c).orElse(null);
        Assertions.assertNull(adminHotelbuscado);
    }

    @Test
    public void actualizarSillaTest()
    {
        Ciudad c1 = new Ciudad("city1");
        Ciudad c2 = new Ciudad("city2");
        Vuelo v = new Vuelo(EstadoVuelo.ABORDED,"Avianca",c1,c2);
        Silla silla = new Silla("B28P",295000.00,v);
        Silla sillaGuardada = sillaRepo.save(silla);

        sillaGuardada.setPosicion("B29V");
        int cod = sillaGuardada.getCodigo();

        sillaRepo.save(sillaGuardada);

        Silla sillaBuscada = sillaRepo.findById(cod).orElse(null);
        Assertions.assertEquals("B29V", sillaBuscada.getPosicion());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarUsuariosTest()
    {
        List<Silla> lista = sillaRepo.findAll();
        System.out.println(lista);
    }
}
