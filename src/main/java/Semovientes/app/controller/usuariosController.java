/*package Semovientes.app.controller;

import Semovientes.app.model.Usuario;
import Semovientes.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.lang.Boolean;

@RestController
@RequestMapping("/usuarios")
public class usuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<Usuario>> getAllUsuarios(){
        List<Usuario> usuario = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario nuevoUsuario){
        Usuario usuario = usuarioService.guardarUsuario(nuevoUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id){
        return usuarioService.obtenerUsuarioPorId(id)
                .map(usuario-> ResponseEntity.ok(usuario))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable long id){

        boolean usuarioEliminado =usuarioService.eliminarUsuarioPorId(id);
        if(usuarioEliminado){
            return ResponseEntity.noContent().build();
        }else{return ResponseEntity.notFound().build();}
    }

    @PutMapping("/{id}")
        public ResponseEntity<Usuario> act_Usuario(@PathVariable long id, @RequestBody Usuario usuarioActualizado){

            return usuarioService.actualizarUsuario(id, usuarioActualizado)
                    .map(usuario -> {
                        return ResponseEntity.ok(usuario);
                    })
                    .orElseGet(() -> {
                        return ResponseEntity.notFound().build();
                    });
                    
        }

    }*/

