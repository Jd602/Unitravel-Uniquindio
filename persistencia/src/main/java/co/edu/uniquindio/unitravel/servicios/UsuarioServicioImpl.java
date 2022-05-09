package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepo usuarioRepo;


    public UsuarioServicioImpl(UsuarioRepo usarioRepo)
    {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {

        Usuario buscado = obtenerUsuario(usuario.getCedula());

        if(buscado != null)
        {
            throw new Exception("El codigo del usuario ya está registrado");
        }

        Usuario usuarioEmail = obtenerUsuario(usuario.getCedula());

        if(usuarioEmail != null)
        {
            throw new Exception("El email del usuario ya está registrado");
        }

        return usuarioRepo.save(usuario);
    }

    public Usuario buscarPorEmail(String email)
    {

        return usuarioRepo.findByCorreo("email").orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception{
        Usuario usuarioBuscado = obtenerUsuario(usuario.getCedula());

        if(usuarioBuscado == null)
        {
            throw new Exception("El usuario que desea eliminar no existe");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String codigo) {
        return usuarioRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception{
        Usuario usuario = obtenerUsuario(cedula);

        if(usuario == null)
        {
            throw new Exception("El usuario no existe");
        }

        usuarioRepo.delete(usuario);


    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario validarLogin(String correo, String password) throws Exception
    {
        Optional<Usuario> usuario = usuarioRepo.findByCorreoAndPassword(correo, password);

        if(usuario == null)
        {
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return usuario.get();
    }
}
