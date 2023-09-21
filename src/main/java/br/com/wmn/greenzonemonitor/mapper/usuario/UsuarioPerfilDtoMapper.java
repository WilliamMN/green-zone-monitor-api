package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioPerfilDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;

public class UsuarioPerfilDtoMapper {

    private UsuarioPerfilDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UsuarioPerfilDto of(Usuario domain) {
        return UsuarioPerfilDto.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .sobrenome(domain.getSobrenome())
                .email(domain.getEmail())
                .build();
    }
}
