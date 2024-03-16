package com.fema.tasklist.usuario.repository;

import com.fema.tasklist.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
