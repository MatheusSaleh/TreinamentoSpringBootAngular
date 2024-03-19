package com.fema.tasklist.tarefa.form;

import com.fema.tasklist.usuario.model.Usuario;
import lombok.Getter;

@Getter
public class TarefaForm {
    private Usuario usuario;

    private String titulo;

    private String descricao;

    private String situacao;
}
