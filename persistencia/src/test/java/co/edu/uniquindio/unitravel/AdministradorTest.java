package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    public void registrarAdministradorTest()
    {
        Administrador administrador = new Administrador("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Administrador administradorGuardado = administradorRepo.save(administrador);

        Assertions.assertNotNull(administradorGuardado);
    }

    @Test
    public void eliminarAdministradorTest()
    {
        Administrador administrador = new Administrador("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Administrador administradorGuardado = administradorRepo.save(administrador);

        administradorRepo.delete(administradorGuardado);

        Administrador administradorBuscado = administradorRepo.findById("1010118570").orElse(null);
        Assertions.assertNull(administradorBuscado);
    }

    @Test
    public void actualizarAdministradorTest()
    {
        Administrador administrador = new Administrador("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Administrador administradorGuardado = administradorRepo.save(administrador);

        administradorGuardado.setNombre("Sebas");

        administradorRepo.save(administradorGuardado);

        Administrador administradorBuscado = administradorRepo.findById("1010118570").orElse(null);
        Assertions.assertEquals("Sebas", administradorBuscado.getNombre());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarAdministradorTest()
    {
        List<Administrador> lista = administradorRepo.findAll();
        System.out.println(lista);
    }
}
