package Semovientes.app.service;
import Semovientes.app.model.RegistroVacunas;
import Semovientes.app.model.Animal;
import Semovientes.app.model.Vacuna;
import Semovientes.app.model.Usuario;
import Semovientes.app.repository.RegistroVacunasRepository;
import Semovientes.app.repository.AnimalesRepository;
import Semovientes.app.repository.VacunasRepository;
import Semovientes.app.repository.UsuarioRepository;
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

  public RegistroVacunas guardarRegistroDeVacuna(RegistroVacunas registroVacuna,Long animalId, Long vacunaId, Long aplicadorId){
    Animal animal = animalesRepository.findById(animalId)
      .orElseThrow(()-> new RuntimeException("Animal no Encontrado"));

    Vacuna vacuna= vacunasRepository.findById(vacunaId)
      .orElseThrow(()-> new RuntimeException("Vacuna no encontrada"));

    Usuario aplicador = usuarioRepository.findById(aplicadorId)
      .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

    registroVacuna.setAnimal(animal);
    registroVacuna.setVacuna(vacuna);
    registroVacuna.setAplicador(aplicador);

    return registroVacunasRepository.save(registroVacuna);
  }

  public Optional<RegistroVacunas> actualizarRegistro(Long id, RegistroVacunas nuevoRegistro, Long animalId, Long vacunaId, Long aplicadorId){
    return registroVacunasRepository.findById(id)
            .map(registro ->{
              registro.setLoteVacuna(nuevoRegistro.getLoteVacuna());
              registro.setDosis(nuevoRegistro.getDosis());
              registro.setTipoDosis(nuevoRegistro.getTipoDosis());
              registro.setFechaVacuna(nuevoRegistro.getFechaVacuna());
              registro.setViaAdministracion(nuevoRegistro.getViaAdministracion());

              if(animalId != null){
                Animal animal = animalesRepository.findById(animalId)
                        .orElseThrow(() -> new RuntimeException("Animal no encontrado"));
                 registro.setAnimal(animal);
              }

              if(vacunaId != null){
                Vacuna vacuna = vacunasRepository.findById(vacunaId)
                        .orElseThrow(() -> new RuntimeException("Vacuna no Encontrada"));
                 registro.setVacuna(vacuna);
              }

              if(aplicadorId != null){
                Usuario usuario = usuarioRepository.findById(aplicadorId)
                        .orElseThrow(() -> new RuntimeException("Aplicador no encontrado"));
                 registro.setAplicador(usuario);
              }
              return registroVacunasRepository.save(registro);
            });
  }

  public boolean eliminarRegistroVacuna(Long id){
    if(registroVacunasRepository.existsById(id)){
      registroVacunasRepository.deleteById(id);
      return true;
    }else{return false;}
  }


}
