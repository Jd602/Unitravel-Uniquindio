package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.TipoCama;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CamaTest {

    @Autowired
    private CamaRepo camaRepo;

    @Test
    public void registrarCamaTest()
    {
        Cama cama = new Cama(TipoCama.DOBLE);
        Cama camaGuardada = camaRepo.save(cama);

        Assertions.assertNotNull(camaGuardada);
    }

    @Test
    public void eliminarCamaTest()
    {
        Cama cama = new Cama(TipoCama.DOBLE);
        Cama camaGuardada = camaRepo.save(cama);

        camaRepo.delete(camaGuardada);
    }

    @Test
    public void actualizarCamaTest()
    {
        Cama cama = new Cama(TipoCama.DOBLE);
        Cama camaGuardada = camaRepo.save(cama);

        camaGuardada.setTipo(TipoCama.SENCILLA);

        camaRepo.save(camaGuardada);

    }

    @Test
    @Sql("classpath:cama.sql")
    public void listarCamaTest()
    {
        List<Cama> lista = camaRepo.findAll();
        System.out.println(lista);
    }

}
