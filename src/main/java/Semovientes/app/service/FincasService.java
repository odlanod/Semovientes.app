
package Semovientes.app.service;

import Semovientes.app.model.Finca;
import Semovientes.app.repository.FincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincasService {

    private final FincasRepository fincasRepository;

public FincasService(FincasRepository fincasRepository){
    this.fincasRepository = fincasRepository;
}

    public List<Finca> obtenerTodasLasFincas() {
        return fincasRepository.findAll();
    }

    public Optional<Finca> obtenerFincaPorId(long id) {
        return fincasRepository.findById(id);
    }

    public Finca guardarFinca(Finca finca) {
        return fincasRepository.save(finca);
    }

    public Boolean eliminarFinca(long id) {
        if(fincasRepository.existsById(id)){
            fincasRepository.deleteById(id);
            return ! fincasRepository.existsById(id);

        }else{return false;}

    }
    public Optional<Finca> actualizarFinca(long id,Finca fincaActualizada){
        return fincasRepository.findById(id)
                .map(fincaExistente->{
                    fincaExistente.setNombre(fincaActualizada.getNombre());
                    fincaExistente.setDescripcion(fincaActualizada.getDescripcion());
                    fincaExistente.setHectareas(fincaActualizada.getHectareas());
                    fincaExistente.setLiberaciones(fincaActualizada.getLiberaciones());
                    return fincasRepository.save(fincaExistente);

                });
    }

}
