package Semovientes.app.service;
import Semovientes.app.model.RegistroAnimales;
import Semovientes.app.model.Usuario;
import Semovientes.app.model.Animal;
import Semovientes.app.repository.RegistroAnimalesRepository;
import Semovientes.app.repository.UsuarioRepository;
import Semovientes.app.repository.AnimalesRepository;
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


public List<RegistroAnimales> obtenerTodosLosRegistrosDeAnimales(){
return registroAnimalesRepository.findAll();
}


public Optional<RegistroAnimales> obtenerRegistroPorId(Long id){
return registroAnimalesRepository.findById(id);
}


public boolean eliminarRegistroAnimales(Long id){
if(registroAnimalesRepository.existsById(id)){
registroAnimalesRepository.deleteById(id);
return true;
}else{return false;}
}


public RegistroAnimales guardarRegistroDeAnimal(RegistroAnimales guardarRegistro,Long usuarioId, Long animalId){
Usuario usuario= usuarioRepository.findById(usuarioId)
.orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

Animal animal= animalesRepository.findById(animalId)
.orElseThrow(()->new RuntimeException("Animal no encontrado"));

guardarRegistro.setUsuario(usuario); 
guardarRegistro.setAnimal(animal);
return registroAnimalesRepository.save(guardarRegistro);
}


public Optional<RegistroAnimales> actualizarRegistroDeAnimal(Long id, RegistroAnimales nuevoRegistro,Long usuarioId, Long animalId){
    return registroAnimalesRepository.findById(id)
            .map(actualizarRegistro->{
                actualizarRegistro.setFechaDeRegistro(nuevoRegistro.getFechaDeRegistro());
                actualizarRegistro.setMovimiento(nuevoRegistro.getMovimiento());
                actualizarRegistro.setCantidad(nuevoRegistro.getCantidad());
                actualizarRegistro.setUnidadMedida(nuevoRegistro.getUnidadMedida());
                actualizarRegistro.setValorKilogramo(nuevoRegistro.getValorKilogramo());
                actualizarRegistro.setValorTotal(nuevoRegistro.getValorTotal());
                actualizarRegistro.setDetalles(nuevoRegistro.getDetalles());

                if(usuarioId != null){
                    Usuario usuario = usuarioRepository.findById(usuarioId)
                            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                    actualizarRegistro.setUsuario(usuario);
                }

                if(animalId != null){
                    Animal animal = animalesRepository.findById(animalId)
                            .orElseThrow(() -> new RuntimeException("Animal no encontrado"));
                    actualizarRegistro.setAnimal(animal);
                }
                return registroAnimalesRepository.save(actualizarRegistro);
            });
}

}
