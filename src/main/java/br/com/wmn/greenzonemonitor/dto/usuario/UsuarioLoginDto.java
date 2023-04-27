package br.com.wmn.greenzonemonitor.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioLoginDto {
    private String email;
    private String senha;
}
