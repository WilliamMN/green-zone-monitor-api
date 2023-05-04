package br.com.wmn.greenzonemonitor.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioLoginDto {

    @Email
    @NotNull(message = "Campo email não pode ser nula")
    @NotEmpty(message = "Campo email não pode ser vazia")
    private String email;

    @NotNull(message = "Campo senha não pode ser nula")
    @NotEmpty(message = "Campo senha não pode ser vazia")
    private String senha;
}
