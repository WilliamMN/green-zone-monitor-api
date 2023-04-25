package br.com.wmn.greenzonemonitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsuarioDetalhadoDto {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;
}
