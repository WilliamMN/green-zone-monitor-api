package br.com.wmn.greenzonemonitor.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioTokenDto {

    private Integer userId;
    private String nome;
    private String email;
    private String token;
}
