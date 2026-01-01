
package Semovientes.app.service;

import Semovientes.app.model.Fincas;
import Semovientes.app.repository.FincasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincasService {

    @Autowired
    private FincasRepository fincasRepository;

    public List<Fincas> obtenerTodasLasFincas() {
        return fincasRepository.findAll();
    }

    public Optional<Fincas> obtenerFincaPorId(int id) {
        return fincasRepository.findById(id);
    }

    public Fincas guardarFinca(Fincas finca) {
        return fincasRepository.save(finca);
    }

    public Boolean eliminarFinca(int id) {
        if(fincasRepository.existsById(id)){
            fincasRepository.deleteById(id);
            return ! fincasRepository.existsById(id);

        }else{return false;}

    }
    public Optional<Fincas> actualizarFinca(int id,Fincas fincaActualizada){
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
