package Semovientes.app.controller;

import Semovientes.app.model.Producto;
import Semovientes.app.service.ProductoService;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        // Asegúrate de que en tu ProductoService el método se llame así
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        model.addAttribute("titulo", "Inventario de Insumos");
        return "productos/lista-productos"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario-producto"; 
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardarProducto(producto);
        // El punto "." es la mejor opción para Codespaces
        return "redirect:."; 
    }
}