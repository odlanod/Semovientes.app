
package Semovientes.app.controller;

import Semovientes.app.model.Fincas;
import Semovientes.app.service.FincasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/finca")
public class FincasController {
    
    private final FincasService fincasService;

    public FincasController(FincasService fincasService){
        this.fincasService = fincasService;
    }

    @GetMapping
    public ResponseEntity <List<Fincas>> getALLFincas(){
        List<Fincas> fincas = fincasService.obtenerTodasLasFincas();
        return ResponseEntity.ok(fincas);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Fincas> createFinca(@RequestBody Fincas fincas){
        Fincas newfincas = fincasService.guardarFinca(fincas);
        return new ResponseEntity<>(newfincas, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fincas> getFincaByID(@PathVariable Integer id) {
        return fincasService.obtenerFincaPorId(id)
                .map(finca -> ResponseEntity.ok(finca))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Fincas> actualizarFinca(@PathVariable int id, @RequestBody Fincas fincaActualizada) {
        return fincasService.actualizarFinca(id,fincaActualizada)
                .map(finca->{
                    return ResponseEntity.ok(finca);
                })
                .orElseGet(()->{
                    return ResponseEntity.notFound().build();
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinca(@PathVariable int id) {
        boolean fincaeliminada = fincasService.eliminarFinca(id);
        if(fincaeliminada){
            return ResponseEntity.noContent().build();
        }else{return ResponseEntity.notFound().build();}
    }
}
