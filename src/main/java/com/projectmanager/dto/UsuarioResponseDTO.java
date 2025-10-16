package com.projectmanager.dto;

import com.projectmanager.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private Usuario.Perfil perfil;
}
