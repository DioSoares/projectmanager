package com.projectmanager.dto;

import com.projectmanager.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Tarefa.Status status;
    private String dataCriacao;
    private String dataConclusao;
    private String projeto;
    private String atribuidoA;
}
