package com.projectmanager.service;

import com.projectmanager.dto.ProjetoRequestDTO;
import com.projectmanager.dto.ProjetoResponseDTO;
import com.projectmanager.exception.ResourceNotFoundException;
import com.projectmanager.model.Projeto;
import com.projectmanager.model.Usuario;
import com.projectmanager.repository.ProjetoRepository;
import com.projectmanager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProjetoResponseDTO criarProjeto(ProjetoRequestDTO dto) {
        Usuario responsavel = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário responsável não encontrado"));

        Projeto projeto = Projeto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .dataInicio(dto.getDataInicio())
                .dataFim(dto.getDataFim())
                .responsavel(responsavel)
                .build();

        Projeto salvo = projetoRepository.save(projeto);
        return toResponseDTO(salvo);
    }

    public List<ProjetoResponseDTO> listarProjetos() {
        return projetoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProjetoResponseDTO buscarPorId(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com ID: " + id));
        return toResponseDTO(projeto);
    }

    public ProjetoResponseDTO atualizarProjeto(Long id, ProjetoRequestDTO dto) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com ID: " + id));

        Usuario responsavel = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário responsável não encontrado"));

        projeto.setNome(dto.getNome());
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());
        projeto.setResponsavel(responsavel);

        Projeto atualizado = projetoRepository.save(projeto);
        return toResponseDTO(atualizado);
    }

    public void deletarProjeto(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto não encontrado com ID: " + id);
        }
        projetoRepository.deleteById(id);
    }

    private ProjetoResponseDTO toResponseDTO(Projeto projeto) {
        return new ProjetoResponseDTO(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDataInicio(),
                projeto.getDataFim(),
                projeto.getResponsavel() != null ? projeto.getResponsavel().getNome() : null
        );
    }
}
