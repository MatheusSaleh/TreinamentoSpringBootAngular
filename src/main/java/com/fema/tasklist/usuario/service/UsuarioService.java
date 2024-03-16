package com.fema.tasklist.usuario.service;

import com.fema.tasklist.exception.ObjetoNaoEncontradoException;
import com.fema.tasklist.usuario.dto.UsuarioDTO;
import com.fema.tasklist.usuario.form.UsuarioForm;
import com.fema.tasklist.usuario.model.Usuario;
import com.fema.tasklist.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(UsuarioDTO.converter(usuarios));
    }

    public ResponseEntity<UsuarioDTO> listarUsuario(Long idUsuario){
        Usuario usuario = this.buscarUsuario(idUsuario);
        return ResponseEntity.ok(UsuarioDTO.fromUsuario(usuario));
    }

    public ResponseEntity<UsuarioDTO> cadastrarUsuario(UsuarioForm formulario){
        Usuario usuario = new Usuario();
        usuario.setNome(formulario.getNome());
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(UsuarioDTO.fromUsuario(usuario));
    }

    public ResponseEntity<UsuarioDTO> atualizarUsuario(Long idUsuario, UsuarioForm formulario){
        Usuario usuario = this.buscarUsuario(idUsuario);
        usuario.setNome(formulario.getNome());
        usuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(UsuarioDTO.fromUsuario(usuario));
    }

    public ResponseEntity<UsuarioDTO> deleteUsuario(Long idUsuario){
        Usuario usuario = this.buscarUsuario(idUsuario);
        this.usuarioRepository.deleteById(idUsuario);
        return ResponseEntity.ok().build();
    }

    public Usuario buscarUsuario(Long idUsuario){
        Optional<Usuario> optionalUsuario = this.usuarioRepository.findById(idUsuario);
        if(optionalUsuario.isEmpty()){
            throw new ObjetoNaoEncontradoException("Usuário não encontrado");
        }
        return optionalUsuario.get();
    }

}
