package br.com.wmn.greenzonemonitor.service;

import br.com.wmn.greenzonemonitor.dto.AutenticarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.UsuarioDetalhadoDto;
import br.com.wmn.greenzonemonitor.exception.ConflitException;
import br.com.wmn.greenzonemonitor.exception.UsuarioNotFoundException;
import br.com.wmn.greenzonemonitor.factory.UsuarioDetalhadoDtoFactory;
import br.com.wmn.greenzonemonitor.factory.UsuarioFactory;
import br.com.wmn.greenzonemonitor.model.Usuario;
import br.com.wmn.greenzonemonitor.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioFactory usuarioFactory;

    private final UsuarioDetalhadoDtoFactory usuarioDetalhadoDtoFactory;

    public void cadastrar(CriarUsuarioDto criarUsuarioDto) {

        boolean emailExiste = usuarioRepository.existsByEmail(criarUsuarioDto.getEmail());

        if (emailExiste) {
            throw new ConflitException("O usuário com o email informado já existe.");
        }

        usuarioRepository.save(usuarioFactory.createUsuario(criarUsuarioDto));
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioDetalhadoDto autenticar(AutenticarUsuarioDto autenticarUsuarioDto) {
        Usuario usuario = usuarioRepository
                .findByEmailAndSenha(autenticarUsuarioDto.getEmail(), autenticarUsuarioDto.getSenha())
                .orElseThrow(UsuarioNotFoundException::new);

        return usuarioDetalhadoDtoFactory.detalharUsuario(usuario);
    }
}
