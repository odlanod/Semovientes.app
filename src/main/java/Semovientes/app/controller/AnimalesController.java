/*package Semovientes.app.controller;

import Semovientes.app.service.AnimalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/animales")
public class AnimalesController {

    @Autowired
    private AnimalesService animalesService;

    @GetMapping
    public String listarAnimales(Model model){
        model.addAttribute("animales", animalesService.obtenerTodasLosAnimales());
        return "animales/animalesListarTodos";
    }





}
*/