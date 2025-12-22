package semovientes.app.service;
import semovientes.app.model.RegistroAnimales;
import semovientes.app.model.Usuario;
import semovientes.app.model.Animales;
import semovientes.app.repository.RegistroAnimalesRepository;
import semovientes.app.repository.UsuarioRepository;
import semovientes.app.repository.AnimalesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroAnimalesService{

private final RegistroAnimalesRepository registroAnimalesRepository;
private final UsuarioRepository usuarioRepository;
private final AnimalesRepository animalesRepository;

public RegistroAnimalesService(RegistroAnimalesRepository registroAnimalesRepository, UsuarioRepository usuarioRepository, AnimalesRepository animalesRepository){
this.registroAnimalesRepository= registroAnimalesRepository;
this.usuarioRepository = usuarioRepository;
this.animalesRepository= animalesRepository;
}


public List<RegistroAnimales> obtenerTodosLosAnimales(){
return registroAnimalesRepository.findAll();
}

public Optional<RegistroAnimales> obtenerRegistroPorId(Long id){
return registroAnimalesRepository.findById(id);
}

public boolean eliminarRegistro(Long id){
if(registroAnimalesRepository.existsById(id)){
registroAnimalesRepository.deleteById(id);
return true;
}else{return false;}
}

public RegistroAnimales guardarRegistroDeAnimal(RegistroAnimales guardarRegistro,Long usuarioId, Long animalId){
Usuario usuario= usuarioRepository.findById(usuarioId)
.orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

Animales animal= animalesRepository.findById(animalId)
.orElseThrow(()->new RuntimeException("Animal no encontrado"));

guardarRegistro.setUsuario(usuario); 
guardarRegistro.setAnimal(animal);
return registroAnimalesRepository.save(guardarRegistro);
}

}
