package com.fema.tasklist.tarefa.model;

import com.fema.tasklist.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
public class Tarefa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private Usuario usuario;

    private String titulo;

    private String descricao;

    private String situacao;
}
