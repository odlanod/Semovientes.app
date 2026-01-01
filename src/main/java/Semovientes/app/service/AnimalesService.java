package Semovientes.app.service;
import Semovientes.app.model.Animales;
import Semovientes.app.model.Fincas;
import Semovientes.app.repository.AnimalesRepository;
import Semovientes.app.repository.FincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;

@Service
public class AnimalesService {

    private final AnimalesRepository animalesRepository;
    private final FincasRepository fincasRepository;

    public AnimalesService(AnimalesRepository animalesRepository, FincasRepository fincasRepository){
        this.animalesRepository = animalesRepository;
        this.fincasRepository = fincasRepository;
    }

    //Traer todos los Animaless--------------------------------------------------
    public List<Animales> obtenerTodasLosAnimales(){
        return animalesRepository.findAll();
    }

    public Optional<Animales> obtenerAnimalPorId(long id){
        return animalesRepository.findById(id);
    }


    @Transactional
     public Animales guardarAnimal(Animales animal){
         return animalesRepository.save(animal);
    }

    @Transactional
    public Boolean eliminarAnimalPorId(long id){
        if(animalesRepository.existsById(id)){
            animalesRepository.deleteById(id);
            return true;
        }else{return false;}
    }

    @Transactional
   public Optional<Animales> actualizarAnimales(long id,Animales animalActualizado, Integer fincaId, Long madreId, Long padreId) {

    return animalesRepository.findById(id).map(animal -> {

        animal.setNombre(animalActualizado.getNombre());
        animal.setEspecie(animalActualizado.getEspecie());
        animal.setRaza(animalActualizado.getRaza());
        animal.setSexo(animalActualizado.getSexo());
        animal.setAdquisicion(animalActualizado.getAdquisicion());
        animal.setFecha(animalActualizado.getFecha());
        animal.setPesoInicial(animalActualizado.getPesoInicial());
        animal.setEstadoAnimal(animalActualizado.getEstadoAnimal());

        if (fincaId != null) {
            Fincas finca = fincasRepository.findById(fincaId)
                    .orElseThrow(() -> new RuntimeException("Finca no existe"));
            animal.setFinca(finca);
        }

        if (madreId != null) {
            Animales madre = animalesRepository.findById(madreId)
                    .orElseThrow(() -> new RuntimeException("Madre no existe"));
            animal.setMadre(madre);
        }

        if (padreId != null) {
            Animales padre = animalesRepository.findById(padreId)
                    .orElseThrow(() -> new RuntimeException("Padre no existe"));
            animal.setPadre(padre);
        }

        return animalesRepository.save(animal);
    });
}




}

