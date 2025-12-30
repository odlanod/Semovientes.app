package Semovientes.app.service;
import Semovientes.app.model.Animales;
import Semovientes.app.model.Fincas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class AnimalesService {

    @Autowired
    private Semovientes.app.repository.AnimalesRepository animalesRepository;
    private Semovientes.app.repository.fincasRepository fincaRepository;

    //Traer todos los Animaless--------------------------------------------------
    public List<Animales> obtenerTodasLosAnimales(){
        return animalesRepository.findAll();
    }

    public Optional<Animales> obtenerAnimalPorId(long id){
        return animalesRepository.findById(id);
    }

    //Insertar nuevo Animal ---------------------------------------------------------
     public Animales guardarAnimal(Animales animal){
         return animalesRepository.save(animal);
    }

    public Boolean eliminarAnimalPorId(long id){
        if(animalesRepository.existsById(id)){
            animalesRepository.deleteById(id);
            return ! animalesRepository.existsById(id);
        }else{return false;}
    }

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
            Fincas finca = fincaRepository.findById(fincaId)
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

