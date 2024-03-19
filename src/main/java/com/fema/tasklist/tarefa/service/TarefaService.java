package com.fema.tasklist.tarefa.service;

import com.fema.tasklist.exception.ObjetoNaoEncontradoException;
import com.fema.tasklist.tarefa.dto.TarefaDTO;
import com.fema.tasklist.tarefa.form.TarefaForm;
import com.fema.tasklist.tarefa.model.Tarefa;
import com.fema.tasklist.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public ResponseEntity<List<TarefaDTO>> listarTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return ResponseEntity.ok(TarefaDTO.converter(tarefas));
    }

    public ResponseEntity<TarefaDTO> listarTarefa(Long idTarefa){
        Tarefa tarefa = this.buscarTarefa(idTarefa);
        return ResponseEntity.ok(TarefaDTO.fromTarefa(tarefa));
    }

    public ResponseEntity<TarefaDTO> cadastrarTarefa(TarefaForm form){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(form.getUsuario().getNome());
        tarefa.setDescricao(form.getDescricao());
        tarefa.setDescricao(form.getDescricao());
        tarefa.setSituacao(form.getSituacao());
        tarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(TarefaDTO.fromTarefa(tarefa));
    }

    public ResponseEntity<TarefaDTO> atualizarTarefa(Long idTarefa, TarefaForm form){
        Tarefa tarefa = this.buscarTarefa(idTarefa);
        tarefa.setTitulo(form.getTitulo());
        tarefa.setDescricao(form.getDescricao());
        tarefa.setSituacao(form.getSituacao());
        tarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(TarefaDTO.fromTarefa(tarefa));
    }

    public ResponseEntity<TarefaDTO> deleteTarefa(Long idTarefa){
        Tarefa tarefa = this.buscarTarefa(idTarefa);
        tarefaRepository.delete(tarefa);
        return ResponseEntity.ok(TarefaDTO.fromTarefa(tarefa));
    }

    public Tarefa buscarTarefa(Long idTarefa){
        Optional<Tarefa> optionalTarefa = this.tarefaRepository.findById(idTarefa);
        if(optionalTarefa.isEmpty()){
            throw new ObjetoNaoEncontradoException("Tarefa não encontrada");
        }
        return optionalTarefa.get();
    }
}
