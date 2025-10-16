package com.projectmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjetoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String responsavel;
}
