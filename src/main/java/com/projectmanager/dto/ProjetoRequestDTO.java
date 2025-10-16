package com.projectmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoRequestDTO {

    @NotBlank
    private String nome;

    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private Long usuarioId;
}
