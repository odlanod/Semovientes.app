package Semovientes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Bienvenido al Sistema Ganadero");
        return "index"; // Esto buscará templates/index.html
    }
}