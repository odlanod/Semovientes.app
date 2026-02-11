package Semovientes.app.controller;

import Semovientes.app.model.Animal;
import Semovientes.app.service.AnimalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller 
@RequestMapping("/animales")
public class AnimalController {

    private final AnimalesService animalesService;

    public AnimalController(AnimalesService animalesService) {
        this.animalesService = animalesService;
    }

    // 1. Ver la lista de animales en una tabla bonita
    @GetMapping
    public String listarAnimales(Model model) {
        List<Animal> lista = animalesService.obtenerTodasLosAnimales();
        model.addAttribute("animales", lista);
        model.addAttribute("titulo", "Panel de Control Ganadero");
        return "animales/listar-Animales.html"; // Nombre del archivo HTML en templates
    }

    // 2. Formulario para agregar un nuevo animal
    @GetMapping("/nuevo")
    public String formularioNuevoAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "formulario-animal"; 
    }

    // 3. Guardar el animal y regresar a la lista
    @PostMapping("/guardar")
    public String guardarAnimal(@ModelAttribute("animal") Animal animal) {
        animalesService.guardarAnimal(animal);
        return "redirect:/vistas/animales";
    }
}