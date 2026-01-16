package Semovientes.app.controller;

import Semovientes.app.model.RegistroVacunas;
import Semovientes.app.service.RegistroVacunaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroVacunas")
public class RegistroVacunasController{

    private final RegistroVacunaService registroVacunaService;

    public RegistroVacunasController(RegistroVacunaService registroVacunaService){
        this.registroVacunaService = registroVacunaService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroVacunas>> obtenerTodosLosRegistros(){
        List<RegistroVacunas> registroVacunas = registroVacunaService.obtenerTodosLosRegistrosDeVacunas();
        return ResponseEntity.ok(registroVacunas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroVacunas> obtenerPorId(@PathVariable Long id) {
        return registroVacunaService.obtenerRegistroDeVacunaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Guardar nuevo registro
    // Se reciben los IDs como parámetros de consulta (Query Params) o podrías ajustarlo según tu preferencia
    @PostMapping
    public ResponseEntity<RegistroVacunas> guardarRegistro(
            @RequestBody RegistroVacunas registroVacuna,
            @RequestParam Long animalId,
            @RequestParam Integer vacunaId,
            @RequestParam Long aplicadorId) {
        try {
            RegistroVacunas nuevoRegistro = registroVacunaService.guardarRegistroDeVacuna(registroVacuna, animalId, vacunaId, aplicadorId);
            return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar registro existente
    @PutMapping("/{id}")
    public ResponseEntity<RegistroVacunas> actualizarRegistro(
            @PathVariable Long id,
            @RequestBody RegistroVacunas nuevoRegistro,
            @RequestParam(required = false) Long animalId,
            @RequestParam(required = false) Integer vacunaId,
            @RequestParam(required = false) Long aplicadorId) {
        try {
            return registroVacunaService.actualizarRegistro(id, nuevoRegistro, animalId, vacunaId, aplicadorId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistroVacuna(@PathVariable Long id){
        boolean registroVacunaEliminado = registroVacunaService.eliminarRegistroVacuna(id);
        if(registroVacunaEliminado){
            return ResponseEntity.noContent().build();
        }else{ResponseEntity.notFound().build();}
    }
}
