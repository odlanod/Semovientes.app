package Semovientes.app.service;

import Semovientes.app.model.Productos;
import Semovientes.app.repository.ProductosRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductosRepository productoRepository;
    public ProductoService(ProductosRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Productos> obtenerTodosLosProductos(){
        return productoRepository.findAll();
    }

    public Optional<Productos> obtenerProductoPorId(long id){
        return productoRepository.findById(id);
    }

    public boolean eliminarProducto(long id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return ! productoRepository.existsById(id);
        }else{return false;}
    }


    public Productos guardarProducto(Productos productos){
        return productoRepository.save(productos);
    }


    public Optional<Productos> actualizarProducto(long id, Productos productos){
        return productoRepository.findById(id)
                .map(producto->{
                  producto.setNombre(productos.getNombre());
                  producto.setTipoProducto(productos.getTipoProducto());
                  producto.setUnidadMedida(productos.getUnidadMedida());
                  producto.setValorUnitario(productos.getValorUnitario());
                  producto.setEstado(productos.getEstado());

                  return productoRepository.save(producto);
                });
    }
}
