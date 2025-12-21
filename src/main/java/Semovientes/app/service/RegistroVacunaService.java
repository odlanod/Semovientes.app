package semovientes.app.service;
import semovientes.app.model.RegistroVacunas;
import semovientes.app.model.Animales;
import semovientes.app.model.Vacunas;
import semovientes.app.model.Usuario;
import semovientes.app.repository.RegistroVacunasRepository;
import semovientes.app.repository.AnimalesRepository;
import semovientes.app.repository.VacunasRepository;
import semovientes.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class RegistroVacunaService{
  
  private final RegistroVacunasRepository registroVacunasRepository;
  private final AnimalesRepository animalesRepository;
  private final VacunasRepository vacunasRepository;
  private final UsuarioRepository usuarioRepository;
  
  public RegistroVacunaService(RegistroVacunasRepository registroVacunasRepository,AnimalesRepository animalesRepository,VacunasRepository vacunasRepository,UsuarioRepository usuarioRepository){
    this.registroVacunasRepository = registroVacunasRepository;
    this.animalesRepository= animalesRepository;
    this.vacunasRepository= vacunasRepository;
    this.usuarioRepository= usuarioRepository;
  }
  
  public List<RegistroVacunas> obtenerTodosLosRegistrosDeVacunas(){
    return registroVacunasRepository.findAll();}

  public Optional<RegistroVacunas> obtenerRegistroDeVacunaPorId(Long idRegistro){
    return registroVacunasRepository.findById(idRegistro);}

  public RegistroVacunas guardarRegistroDeVacuna(RegistroVacunas registroVacuna,Long animalId, Integer vacunaId, Long aplicadorId){
    Animales animal = animalesRepository.findById(animalId)
      .orElseThrow(()-> new RuntimeException("Animal no Encontrado"));

    Vacunas vacuna= vacunasRepository.findById(vacunaId)
      .orElseThrow(()-> new RuntimeException("Vacuna no encontrada"));

    Usuario aplicador = usuarioRepository.findById(aplicadorId)
      .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

    registroVacuna.setAnimal(animal);
    registroVacuna.setVacuna(vacuna);
    registroVacuna.setAplicador(aplicador);

    return registroVacunasRepository.save(registroVacuna);
  }
}
