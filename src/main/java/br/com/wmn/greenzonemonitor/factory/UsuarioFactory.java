package br.com.wmn.greenzonemonitor.factory;

import br.com.wmn.greenzonemonitor.dto.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFactory {

    public Usuario createUsuario(CriarUsuarioDto dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }
}
