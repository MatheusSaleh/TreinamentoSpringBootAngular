package com.fema.tasklist.usuario.resource;

import com.fema.tasklist.usuario.dto.UsuarioDTO;
import com.fema.tasklist.usuario.form.UsuarioForm;
import com.fema.tasklist.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return this.usuarioService.listarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> listarUsuario(@PathVariable Long idUsuario){
        return this.usuarioService.listarUsuario(idUsuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioForm formulario){
        return this.usuarioService.cadastrarUsuario(formulario);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioForm formulario){
        return this.usuarioService.atualizarUsuario(idUsuario, formulario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> deleteUsuario(@PathVariable Long idUsuario){
        return this.usuarioService.deleteUsuario(idUsuario);
    }


}
