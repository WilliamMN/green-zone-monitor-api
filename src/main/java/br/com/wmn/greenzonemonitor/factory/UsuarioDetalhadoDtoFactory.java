package br.com.wmn.greenzonemonitor.factory;

import br.com.wmn.greenzonemonitor.dto.UsuarioDetalhadoDto;
import br.com.wmn.greenzonemonitor.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDetalhadoDtoFactory {

    public UsuarioDetalhadoDto detalharUsuario(Usuario model) {
        return UsuarioDetalhadoDto.builder()
                .id(model.getId())
                .nome(model.getNome())
                .sobrenome(model.getSobrenome())
                .email(model.getEmail())
                .build();
    }
}
