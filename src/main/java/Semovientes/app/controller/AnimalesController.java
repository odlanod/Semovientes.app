package Semovientes.app.controller;

import Semovientes.app.model.Animales;
import Semovientes.app.service.AnimalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animales")
public class AnimalesController {

private final AnimalesService animalesService;

public AnimalesController(AnimalesService animalesService){
    this.animalesService = animalesService;
}


    @GetMapping
    public ResponseEntity<List<Animales>> obtenerTodosLosAnimales(){

    List<Animales> animales = animalesService.obtenerTodasLosAnimales();
    return ResponseEntity.ok(animales);
    }

    @PostMapping
    public ResponseEntity<Animales> guardarAnimal(@RequestBody Animales newAnimal){
    Animales animal = animalesService.guardarAnimal(newAnimal);
    return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnimal(@PathVariable Long id){
    boolean animalEliminado = animalesService.eliminarAnimalPorId(id);

    if(animalEliminado){
        return ResponseEntity.noContent().build();
    }else{return ResponseEntity.notFound().build();}
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animales> obtenerAnimalPorId(@PathVariable Long id){
    return animalesService.obtenerAnimalPorId(id)
            .map(animal -> ResponseEntity.ok(animal))
            .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animales> actualizar(@RequestBody Animales animalActualizado, @PathVariable Long id, @RequestParam(required = false) Integer idFinca,
                                               @RequestParam(required = false) Long idPadre, @RequestParam(required = false) Long idMadre){
    return animalesService.actualizarAnimales(id,animalActualizado, idFinca, idPadre, idMadre )
            .map(animal ->{return ResponseEntity.ok(animal);})
            .orElseGet(() ->{return ResponseEntity.notFound().build();});
    }



}
