package Semovientes.app.service;
import semovientes.app.model.RegistroVacunas;
import semovientes.app.repository.RegistroVacunasRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class RegistroVacunaService{
  
private final RegistroVacunasRepository registroVacunasRepository;
  
  public RegistroVacunaService(RegistroVacunasRepository registroVacunasRepository){
    this.registroVacunasRepository = registroVacunasRepository;}
  
  public List<RegistroVacunas> obtenerTodosLosRegistrosDeVacunas(){
    return registroVacunasRepository.findAll();}

  public Optional<RegistroVacunas> obtenerRegistroDeVacunaPorId(long idRegistro){
    return registroVacunasRepository.findById(idRegistro);}

  /*public RegistroVacunas guardarRegistroDeVacuna(Registro_Vacunas registroVacuna){}*/
}
