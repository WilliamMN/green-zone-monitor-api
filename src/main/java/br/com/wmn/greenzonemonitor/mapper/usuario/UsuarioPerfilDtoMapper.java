package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioPerfilDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPerfilDtoMapper {

    public UsuarioPerfilDto of(Usuario domain) {
        return UsuarioPerfilDto.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .sobrenome(domain.getSobrenome())
                .email(domain.getEmail())
                .build();
    }
}
