package br.com.wmn.greenzonemonitor.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CriarUsuarioDto {

    @NotNull(message = "Campo nome não pode ser nula")
    @NotEmpty(message = "Campo nome não pode ser vazia")
    private String nome;

    @NotEmpty(message = "Campo sobrenome não pode ser vazia")
    private String sobrenome;

    @Email
    @NotNull(message = "Campo email não pode ser nula")
    @NotEmpty(message = "Campo email não pode ser vazia")
    private String email;

    @NotNull(message = "Campo senha não pode ser nula")
    @NotEmpty(message = "Campo senha não pode ser vazia")
    private String senha;
}
