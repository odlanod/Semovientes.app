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
                .map(fincaExistente->{

                });

        }


    
    
    }




}

*/