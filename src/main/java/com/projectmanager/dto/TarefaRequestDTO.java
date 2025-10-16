package com.projectmanager.dto;

import com.projectmanager.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TarefaRequestDTO {

    @NotBlank
    private String titulo;

    private String descricao;
    private Tarefa.Status status;
    private LocalDate dataConclusao;
    private Long projetoId;
    private Long usuarioId;
}
