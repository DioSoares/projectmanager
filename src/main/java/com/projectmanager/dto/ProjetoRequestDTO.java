package com.projectmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjetoRequestDTO {

    @NotBlank
    private String nome;

    private String descricao;
    private String dataInicio;
    private String dataFim;

    private Long usuarioId;
}
