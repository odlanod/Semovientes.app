package Semovientes.app.service;
import Semovientes.app.model.Vacunas;
import Semovientes.app.repository.VacunasRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class VacunaService{
  
private final VacunasRepository vacunaRepository;
  public VacunaService(VacunasRepository vacunaRepository){
    this.vacunaRepository= vacunaRepository;}
  
  public List<Vacunas> obtenerTodasLasVacunas(){
    return vacunaRepository.findAll();}

  public Optional<Vacunas> obtenerVacunasPorId(int id){
    return vacunaRepository.findById(id);}

  public boolean eliminarVacuna(int id){
    if(vacunaRepository.existsById(id)){
      vacunaRepository.deleteById(id);
      return true;
    }else{return false;}}

  public Vacunas guardarVacuna(Vacunas vacuna){
    return vacunaRepository.save(vacuna);}

  public Optional<Vacunas> actualizarVacuna(Integer id, Vacunas vacunas){
    return vacunaRepository.findById(id)
      .map(actualizar->{
          actualizar.setNombre(vacunas.getNombre());
          return vacunaRepository.save(actualizar);
      });
  }
}
