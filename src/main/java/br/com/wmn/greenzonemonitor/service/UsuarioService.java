package br.com.wmn.greenzonemonitor.service;

import br.com.wmn.greenzonemonitor.dto.AutenticarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.UsuarioDetalhadoDto;
import br.com.wmn.greenzonemonitor.exception.UsuarioConflitException;
import br.com.wmn.greenzonemonitor.exception.UsuarioNotFoundException;
import br.com.wmn.greenzonemonitor.mapper.UsuarioDetalhadoDtoMapper;
import br.com.wmn.greenzonemonitor.mapper.UsuarioMapper;
import br.com.wmn.greenzonemonitor.model.Usuario;
import br.com.wmn.greenzonemonitor.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioDetalhadoDtoMapper usuarioDetalhadoDtoMapper;

    public void cadastrar(CriarUsuarioDto criarUsuarioDto) {

        boolean emailExiste = usuarioRepository.existsByEmail(criarUsuarioDto.getEmail());

        if (emailExiste) {
            throw new UsuarioConflitException("O usuário com o email informado já existe.");
        }

        usuarioRepository.save(usuarioMapper.createUsuario(criarUsuarioDto));
    }

    public List<UsuarioDetalhadoDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioDetalhadoDtoMapper::detalharUsuario)
                .toList();
    }

    public UsuarioDetalhadoDto autenticar(AutenticarUsuarioDto autenticarUsuarioDto) {
        Usuario usuario = usuarioRepository
                .findByEmailAndSenha(autenticarUsuarioDto.getEmail(), autenticarUsuarioDto.getSenha())
                .orElseThrow(UsuarioNotFoundException::new);

        return usuarioDetalhadoDtoMapper.detalharUsuario(usuario);
    }
}
