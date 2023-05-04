package br.com.wmn.greenzonemonitor.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioPerfilDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
}
