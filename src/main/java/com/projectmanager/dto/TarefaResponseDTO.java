package com.projectmanager.dto;

import com.projectmanager.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Tarefa.Status status;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private String projeto;
    private String atribuidoA;
}
