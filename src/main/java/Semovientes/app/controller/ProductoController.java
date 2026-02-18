@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("titulo", "Inventario de Insumos");
        return "productos/lista-productos"; // Ruta: templates/productos/lista-productos.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario-producto"; // Ruta: templates/productos/formulario-producto.html
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardar(producto);
        // Usamos ruta relativa para evitar el error 404 en Codespaces
        return "redirect:."; 
    }
}