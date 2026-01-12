package Semovientes.app.controller;

import Semovientes.app.model.RegistroAnimales;
import Semovientes.app.service.RegistroAnimalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.lang.Boolean;

@RestController
@RequestMapping("/registroAnimales")
public class RegistroAnimalesController{

    private final RegistroAnimalesService registroAnimalesService;

    public RegistroAnimalesController(RegistroAnimalesService registroAnimalesService){
        this.registroAnimalesService = registroAnimalesService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroAnimales>> obtenerTodosLosRegistrosDeAnimales(){
        RegistroAnimales registroAnimales= registroAnimalesService.obtenerTodosLosRegistrosDeAnimales();
        return ResponseEntity.ok(registroAnimales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAnimales> obtenerAnimalPorId(@PathVariable Long id){
        return registroAnimalesService.obtenerRegistroPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistro(@PathVariable Long id){
        
    }
}