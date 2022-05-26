package co.edu.uniquindio.unitravel.test;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrarUsuarioTest()
    {
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminarUsuarioTest()
    {
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("1010118570").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    public void actualizarUsuarioTest()
    {
        Usuario usuario = new Usuario("1010118570", "Esteban", "es.tola2010@hotmail.com", "123456");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioGuardado.setNombre("Sebas");

        usuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("1010118570").orElse(null);
        Assertions.assertEquals("Sebas", usuarioBuscado.getNombre());
    }

    @Test
    @Sql("classpath:registros.sql")
    public void listarUsuariosTest()
    {
        List<Usuario> lista = usuarioRepo.findAll();
        System.out.println(lista);
    }
}
