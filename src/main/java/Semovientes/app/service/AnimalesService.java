/*package Semovientes.app.service;
import Semovientes.app.model.Animales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalesService {

    @Autowired
    private Semovientes.app.repository.AnimalesRepository animalesRepository;

    //Traer todos los Animaless--------------------------------------------------
    public List<Animales> obtenerTodasLosAnimales(){
        return animalesRepository.findAll();
    }

    //Traer Animal Por Id --------------------------------------------------------
    public Animales obtenerAnimalPorId(int id){
        return animalesRepository.findById(id).orElse(null);
    }

    //Insertar nuevo Animal ---------------------------------------------------------
    public Animales guardarAnimales(Animales animales){
        return animalesRepository.save(animales);
    }




}*/
