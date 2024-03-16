package com.fema.tasklist.usuario.dto;

import com.fema.tasklist.usuario.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record UsuarioDTO(Long id, String nome) {
    public static UsuarioDTO fromUsuario(Usuario usuario){
        return new UsuarioDTO(usuario.getId(), usuario.getNome());
    }

    public static List<UsuarioDTO> converter(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDTO::fromUsuario).collect(Collectors.toList());
    }
}
