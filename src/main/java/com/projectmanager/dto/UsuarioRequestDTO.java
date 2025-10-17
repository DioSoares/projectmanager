package com.projectmanager.dto;

import com.projectmanager.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;

    @NotNull(message = "O perfil não pode estar vazio")
    private Usuario.Perfil perfil;
}
