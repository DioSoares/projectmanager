package com.projectmanager.controller;

import com.projectmanager.dto.TarefaRequestDTO;
import com.projectmanager.dto.TarefaResponseDTO;
import com.projectmanager.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.criarTarefa(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
