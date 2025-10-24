package com.projectmanager.controller;

import com.projectmanager.dto.UsuarioRequestDTO;
import com.projectmanager.dto.UsuarioResponseDTO;
import com.projectmanager.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Gerenciamento de usuários do sistema (Admin, Gerente, Desenvolvedor, etc)")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Criar novo usuário", description = "Adiciona um novo usuário informando nome, email, senha e perfil")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody @Valid UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }

    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados no sistema.")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuario());
    }

    @Operation(summary = "Buscar usuário por ID", description = "Localiza um usuário existente pelo identificador único (ID).")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar usuário", description = "Atualiza as informações de um usuário existente.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, dto));
    }
    @Operation(summary = "Excluir usuário", description = "Remove um usuário existente a partir do seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
