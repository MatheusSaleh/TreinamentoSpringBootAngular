package com.fema.tasklist.tarefa.dto;

import com.fema.tasklist.tarefa.model.Tarefa;
import com.fema.tasklist.usuario.model.Usuario;

import java.util.List;

public record TarefaDTO(Long id, Usuario usuario, String titulo, String descricao, String situacao) {

    public static TarefaDTO fromTarefa(Tarefa tarefa){
        return new TarefaDTO(tarefa.getId(), tarefa.getUsuario(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getSituacao());
    }

    public static List<TarefaDTO> converter(List<Tarefa> tarefas){
        return tarefas.stream().map(TarefaDTO::fromTarefa).toList();
    }
}
