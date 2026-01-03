package Semovientes.app.controller;

import Semovientes.app.model.Productos;
import Semovientes.app.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductoService productoService;

    public ProductosController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Productos>> obtenerTodosLosProductos(){
        List<Productos> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtenerProductoPorId(@PathVariable Long id){
        return productoService.obtenerProductoPorId(id)
                .map(producto -> ResponseEntity.ok(producto))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Productos> guardarProducto(@RequestBody Productos newProducto){
        Productos producto = productoService.guardarProducto(newProducto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        boolean productoEliminado = productoService.eliminarProducto(id);

        if (productoEliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Long id, @RequestBody Productos newProducto ){
        return productoService.actualizarProducto(id, newProducto)
                .map(producto->{return ResponseEntity.ok(producto);})
                .orElseGet(()->{return ResponseEntity.notFound().build();});
    }

}
