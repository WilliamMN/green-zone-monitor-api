package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioTokenDtoMapper {

    public UsuarioTokenDto of (Usuario usuario, String token) {
        return UsuarioTokenDto.builder()
                .userId(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .token(token)
                .build();
    }
}
