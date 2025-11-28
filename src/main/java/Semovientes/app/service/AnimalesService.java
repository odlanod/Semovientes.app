/*package Semovientes.app.service;
import Semovientes.app.model.Animales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalesService {

    @Autowired
    private Semovientes.app.repository.AnimalesRepository animalesRepository;

    //Traer todos los Animaless--------------------------------------------------
    public List<Animales> obtenerTodasLosAnimales(){
        return animalesRepository.findAll();
    }

    //Traer Animal Por Id --------------------------------------------------------
    public Optional<Animales> obtenerAnimalPorId(long id){
        return animalesRepository.findById(id);
    }

    //Insertar nuevo Animal ---------------------------------------------------------
     public Animales guardarAnimal(Animales animales){
        return animalesRepository.save(animales);
    }

    public Boolean eliminarAnimalPorId(long id){
        if(animalesRepository.existsById(id)){
            animalesRepository.deleteById(id);
            return ! animalesRepository.existsById(id);
        }else{return false;}
    }

    public Optional<Animales> actualizarAnimales(long id, Animales animalActualizado){

        return animalesRepository.findById(id)
                .map(animalExistente->{
                    animalExistente.setNombre(animalActualizado.getNombre());
                    animalExistente.setApellidos(animalActualizado.getApellidos());
                    animalExistente.setCedula(animalActualizado.getCedula());
                    animalExistente.setCorreoElectonico(animalActualizado.getCorreoElectonico());
                    animalExistente.setFecha_Nacimiento_usuario(animalActualizado.getFecha_Nacimiento_usuario());
                    animalExistente.setPassword(animalActualizado.getPassword());
                    animalExistente.setRol(animalActualizado.getRol());
                    animalExistente.setSueldo(animalActualizado.getSueldo());
                    animalExistente.setEstado(animalActualizado.getEstado());
                    animalExistente.setGenero(animalActualizado.getGenero());

                    return animalesRepository.save(animalExistente);
                        }

                );
    }
    
    
    }




}*/

