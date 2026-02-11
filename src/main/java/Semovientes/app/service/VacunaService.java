package Semovientes.app.service;
import Semovientes.app.model.Vacuna;
import Semovientes.app.repository.VacunasRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class VacunaService{
  
private final VacunasRepository vacunaRepository;
  public VacunaService(VacunasRepository vacunaRepository){
    this.vacunaRepository= vacunaRepository;}
  
  public List<Vacuna> obtenerTodasLasVacunas(){
    return vacunaRepository.findAll();}

  public Optional<Vacuna> obtenerVacunasPorId(long id){
    return vacunaRepository.findById(id);}

  public boolean eliminarVacuna(long id){
    if(vacunaRepository.existsById(id)){
      vacunaRepository.deleteById(id);
      return true;
    }else{return false;}}

  public Vacuna guardarVacuna(Vacuna vacuna){
    return vacunaRepository.save(vacuna);}

  public Optional<Vacuna> actualizarVacuna(Long id, Vacuna vacunas){
    return vacunaRepository.findById(id)
      .map(actualizar->{
          actualizar.setNombre(vacunas.getNombre());
          return vacunaRepository.save(actualizar);
      });
  }
}
