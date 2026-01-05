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
  public ResponseEntity<List<Vacunas>> obtenerTodosLasVacunas(){
    List<Vacunas> vacunas = vacunaService.obtenerTodasLasVacunas();
      return ResponseEntity.ok(vacunas);
  }

  public ResponseEntity<Vacunas> obtenerVacunaPorId(@PathVariable ){}
}
