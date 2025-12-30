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






}
