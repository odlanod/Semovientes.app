
package Semovientes.app.service;

import Semovientes.app.model.Finca;
import Semovientes.app.repository.FincaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincasService {

    @Autowired
    private FincaRepository fincasRepository;

    public List<Finca> obtenerTodasLasFincas() {
        return fincasRepository.findAll();
    }

    public Optional<Finca> obtenerFincaPorId(int id) {
        return fincasRepository.findById(id);
    }

    public Finca guardarFinca(Finca finca) {
        return fincasRepository.save(finca);
    }

    public Boolean eliminarFinca(int id) {
        if(fincasRepository.existsById(id)){
            fincasRepository.deleteById(id);
            return ! fincasRepository.existsById(id);

        }else{return false;}

    }
    public Optional<Finca> actualizarFinca(int id,Finca fincaActualizada){
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
