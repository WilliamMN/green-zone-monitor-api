package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioCriarDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Usuario of(UsuarioCriarDto dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }
}
