package com.projectmanager.service;

import com.projectmanager.dto.TarefaRequestDTO;
import com.projectmanager.dto.TarefaResponseDTO;
import com.projectmanager.exception.ResourceNotFoundException;
import com.projectmanager.model.Projeto;
import com.projectmanager.model.Tarefa;
import com.projectmanager.model.Usuario;
import com.projectmanager.repository.ProjetoRepository;
import com.projectmanager.repository.TarefaRepository;
import com.projectmanager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto) {
        Projeto projeto = projetoRepository.findById(dto.getProjetoId())
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado"));
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Tarefa tarefa = Tarefa.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .status(dto.getStatus() != null ? dto.getStatus() : Tarefa.Status.PENDENTE)
                .dataCriacao(LocalDate.now())
                .dataConclusao(dto.getDataConclusao())
                .projeto(projeto)
                .atribuidoA(usuario)
                .build();

        Tarefa salvo = tarefaRepository.save(tarefa);
        return toResponseDTO(salvo);
    }

    public List<TarefaResponseDTO> listarTarefas() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO buscarPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com ID: " + id));
        return toResponseDTO(tarefa);
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com ID: " + id));

        Projeto projeto = projetoRepository.findById(dto.getProjetoId())
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado"));
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDataConclusao(dto.getDataConclusao());
        tarefa.setProjeto(projeto);
        tarefa.setAtribuidoA(usuario);

        Tarefa atualizada = tarefaRepository.save(tarefa);
        return toResponseDTO(atualizada);
    }

    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarefa não encontrada com ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }

    private TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDataCriacao(),
                tarefa.getDataConclusao(),
                tarefa.getProjeto() != null ? tarefa.getProjeto().getNome() : null,
                tarefa.getAtribuidoA() != null ? tarefa.getAtribuidoA().getNome() : null
        );
    }
}
