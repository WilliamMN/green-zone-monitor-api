package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;

public class UsuarioTokenDtoMapper {

    private UsuarioTokenDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UsuarioTokenDto of(Usuario usuario, String token) {
        return UsuarioTokenDto.builder()
                .userId(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .token(token)
                .build();
    }
}
