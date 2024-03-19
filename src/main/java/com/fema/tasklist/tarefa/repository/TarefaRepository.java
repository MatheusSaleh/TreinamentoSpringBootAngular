package com.fema.tasklist.tarefa.repository;

import com.fema.tasklist.tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
