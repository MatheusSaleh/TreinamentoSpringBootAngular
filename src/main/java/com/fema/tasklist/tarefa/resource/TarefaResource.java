package com.fema.tasklist.tarefa.resource;

import com.fema.tasklist.tarefa.dto.TarefaDTO;
import com.fema.tasklist.tarefa.form.TarefaForm;
import com.fema.tasklist.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tarefas")
@RestController
public class TarefaResource {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarTarefas(){
        return this.tarefaService.listarTarefas();
    }

    @GetMapping("/{idTarefa}")
    public ResponseEntity<TarefaDTO> listarTarefa(@PathVariable Long idTarefa){
        return this.tarefaService.listarTarefa(idTarefa);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> cadastrarTarefa(@RequestBody TarefaForm tarefaForm){
        return this.tarefaService.cadastrarTarefa(tarefaForm);
    }

    @PutMapping("/{idTarefa}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long idTarefa, @RequestBody TarefaForm tarefaForm){
        return this.tarefaService.atualizarTarefa(idTarefa, tarefaForm);
    }

    @DeleteMapping("/{idTarefa}")
    public ResponseEntity<TarefaDTO> deleteTarefa(@PathVariable Long idTarefa){
        return this.tarefaService.deleteTarefa(idTarefa);
    }
}
