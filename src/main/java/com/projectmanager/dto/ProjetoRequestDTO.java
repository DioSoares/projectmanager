package com.projectmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoRequestDTO {

    @NotBlank(message = "O nome do projeto não pode estar vazio")
    private String nome;

    @NotBlank(message = "A descrição do projeto não pode estar vazia")

    @NotBlank(message = "A descrição do projeto não pode estar vazia")
    private String descricao;

    @NotBlank(message = "A data de início não pode ser nula")
    private LocalDate dataInicio;

    @NotBlank(message = "A data de fim do projeto não pode ser nula")
    private LocalDate dataFim;

    @NotNull(message = "O ID do usuário responsável e obrigatório")
    private Long usuarioId;
}
