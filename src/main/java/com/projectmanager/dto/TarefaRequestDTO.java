package com.projectmanager.dto;

import com.projectmanager.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TarefaRequestDTO {

    @NotBlank(message = "O título da tarefa não pode estar vazio")
    private String titulo;

    @NotBlank(message = "A descrição da tarefa não pode estar vazia")
    private String descricao;

    @NotBlank(message = "O status da tarefa não pode estar vazio")
    private Tarefa.Status status;

    @NotBlank(message = "A data de conclusão da tarefa e obrigatória")
    private LocalDate dataConclusao;

    @NotNull(message = "O ID do projeto é obrigatório")
    private Long projetoId;

    @NotNull(message = "O ID do usuário responsavel é obrigatório")
    private Long usuarioId;
}
