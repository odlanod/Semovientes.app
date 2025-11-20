package Semovientes.app.service;
import Semovientes.app.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    Semovientes.app.repository.UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(long id){
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Boolean eliminarUsuarioPorId(long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ! usuarioRepository.existsById(id);
        }else{return false;}
    }

    public Optional<Usuario> actualizarUsuario(long id, Usuario usuarioActualizado){

        return usuarioRepository.findById(id)
                .map(usuarioExistente->{
                    usuarioExistente.setNombre(usuarioActualizado.getNombre());
                    usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
                    usuarioExistente.setCedula(usuarioActualizado.getCedula());
                    usuarioExistente.setCorreoElectonico(usuarioActualizado.getCorreoElectonico());
                    usuarioExistente.setFecha_Nacimiento_usuario(usuarioActualizado.getFecha_Nacimiento_usuario());
                    usuarioExistente.setPassword(usuarioActualizado.getPassword());
                    usuarioExistente.setRol(usuarioActualizado.getRol());
                    usuarioExistente.setSueldo(usuarioActualizado.getSueldo());
                    usuarioExistente.setEstado(usuarioActualizado.getEstado());
                    usuarioExistente.setGenero(usuarioActualizado.getGenero());

                    return usuarioRepository.save(usuarioExistente);
                        }

                );
    }




}
