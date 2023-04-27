package br.com.wmn.greenzonemonitor.mapper.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario of(CriarUsuarioDto dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }
}
