package Semovientes.app.controller;

import Semovientes.app.model.Vacunas;
import Semovientes.app.service.VacunaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacunas")
public class VacunasController {

  private final VacunaService vacunaService;

  public VacunasController(VacunaService vacunaService){
    this.vacunaService = vacunaService;
  }

  @GetMapping
  public ResponseEntity<List<Vacunas>> obtenerTodasLasVacunas(){
    List<Vacunas> vacunas = vacunaService.obtenerTodasLasVacunas();
      return ResponseEntity.ok(vacunas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Vacunas> obtenerVacunaPorId(@PathVariable Integer id ){
    return vacunaService.obtenerVacunasPorId(id).
                        map(vacuna -> ResponseEntity.ok(vacuna))
                        .oeElseGet(() -> ResponseEntity.notFount().build());
  }

  @PostMapping
  public ResponseEntity<Vacunas> guardarVacuna(@RequestBody Vacunas newVacuna){
    Vacunas vacuna = vacunaService.guardarVacuna(newVacuna);
    return new ResponseEntity<>(vacuna, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarVacuna(@PathVariable Integer id){
    boolean vacunaEliminada = vacunaService.eliminarVacuna();
    if(vacunaEliminada){
      return ResponseEntity.noContent().build();
    }else{return ResponseEntity.notFound().build();}
  }


  @PutMapping("/{id}")
  public ResponseEntity<Vacunas> actualizarVacuna(@PathVariable Integer id, @RequestBody Vacunas newVacuna){
    return vacunaService.actualizarVacuna(id, newVacuna)
                        .map(vacuna->{return ResponseEntity.ok(vacuna);})
                        .orElseGet(()->{return ResponseEntity.notFound().build();});
  }
  
}
