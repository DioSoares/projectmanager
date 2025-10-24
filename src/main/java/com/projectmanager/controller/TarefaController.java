package com.projectmanager.controller;

import com.projectmanager.dto.TarefaRequestDTO;
import com.projectmanager.dto.TarefaResponseDTO;
import com.projectmanager.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Gerenciamento de tarefas vinculadas a projetos")
public class TarefaController {

    private final TarefaService tarefaService;


    @Operation(summary = "Criar tarefa", description = "Adiciona uma nova tarefa a um projeto existente.")
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.criarTarefa(dto));
    }

    @Operation(summary = "Listar tarefas", description = "Retorna todas as tarefas registradas no sistema.")
    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Obtém informações detalhadas sobre uma tarefa específica.")
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar tarefa", description = "Edita as informações de uma tarefa existente.")
    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, dto));
    }

    @Operation(summary = "Excluir tarefa", description = "Remove uma tarefa do sistema a partir do ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
