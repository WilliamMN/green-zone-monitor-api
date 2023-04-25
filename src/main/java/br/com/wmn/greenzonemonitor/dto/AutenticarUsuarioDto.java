package br.com.wmn.greenzonemonitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AutenticarUsuarioDto {
    private String email;
    private String senha;
}
