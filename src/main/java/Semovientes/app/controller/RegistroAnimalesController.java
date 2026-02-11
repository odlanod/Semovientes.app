/*package Semovientes.app.controller;

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
        boolean registroEliminado = registroAnimalesService.eliminarRegistroAnimales(id);
        if(registroEliminado){
            return ResponseEntity.noContent().build();
        }else{return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RegistroAnimales> guardarRegistroAnimal(@RequestBody RegistroAnimales registroAnimales, 
    @RequestParam Long usuarioId, @RequestParam Long animalId){

        try{
            RegistroAnimales nuevoRegistroAnimal = registroAnimalesService.guardarRegistroDeAnimal(registroAnimales,usuarioId,animalId);
            return new ResponseEntity<>(nuevoRegistroAnimal,HttpStatus.CREATRD);
        }catch(RunTimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroAnimales> actualizarRegistroAnimal(@PathVariable Long id, @RequestBody RegistroAnimales registroAnimales,
    @RequestParam(required = false) Long usuarioId, @RequestParam(required=false) Long animalId){
        try{}catch(){}
    }
}*/