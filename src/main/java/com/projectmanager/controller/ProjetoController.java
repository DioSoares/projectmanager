package com.projectmanager.controller;

import com.projectmanager.dto.ProjetoRequestDTO;
import com.projectmanager.dto.ProjetoResponseDTO;
import com.projectmanager.service.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projetos")
@RequiredArgsConstructor
@Tag(name = "Projetos", description = "Gerenciamento de projetos e seus responsáveis")
public class ProjetoController {

    private final ProjetoService projetoService;

    @Operation(summary = "Criar novo projeto", description = "Cria um novo projeto com título, descrição e responsável.")
    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid ProjetoRequestDTO dto) {
        return ResponseEntity.ok(projetoService.criarProjeto(dto));
    }

    @Operation(summary = "Listar projetos", description = "Retorna todos os projetos cadastrados.")
    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> listarProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @Operation(summary = "Buscar projeto por ID", description = "Retorna os detalhes de um projeto específico.")
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar projeto", description = "Atualiza informações de um projeto existente.")
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> atualizarProjeto(@PathVariable Long id, @RequestBody @Valid ProjetoRequestDTO dto) {
        return ResponseEntity.ok(projetoService.atualizarProjeto(id, dto));
    }

    @Operation(summary = "Excluir projeto", description = "Remove um projeto existente a partir do ID informado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
