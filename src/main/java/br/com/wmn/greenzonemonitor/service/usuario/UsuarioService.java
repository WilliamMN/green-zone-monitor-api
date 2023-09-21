package br.com.wmn.greenzonemonitor.service.usuario;

import br.com.wmn.greenzonemonitor.config.security.jwt.GerenciadorTokenJwt;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioCriarDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioLoginDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioPerfilDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.exception.UsuarioConflitException;
import br.com.wmn.greenzonemonitor.exception.UsuarioNotFoundException;
import br.com.wmn.greenzonemonitor.mapper.usuario.UsuarioMapper;
import br.com.wmn.greenzonemonitor.mapper.usuario.UsuarioPerfilDtoMapper;
import br.com.wmn.greenzonemonitor.mapper.usuario.UsuarioTokenDtoMapper;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import br.com.wmn.greenzonemonitor.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;

    private final UsuarioRepository usuarioRepository;

    private final GerenciadorTokenJwt gerenciadorTokenJwt;

    private final AuthenticationManager authenticationManager;


    public List<UsuarioPerfilDto> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioPerfilDtoMapper::of).toList();
    }

    public void cadastrar(UsuarioCriarDto usuarioCriarDto) {

        boolean emailExiste = usuarioRepository.existsByEmail(usuarioCriarDto.getEmail());

        if (emailExiste) {
            throw new UsuarioConflitException("O usuário com o email informado já existe.");
        }

        usuarioCriarDto.setSenha(passwordEncoder.encode(usuarioCriarDto.getSenha()));

        usuarioRepository.save(UsuarioMapper.of(usuarioCriarDto));
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {
        final UsernamePasswordAuthenticationToken credentials =
                new UsernamePasswordAuthenticationToken(usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                .orElseThrow(() -> new UsuarioNotFoundException(usuarioLoginDto.getEmail()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioTokenDtoMapper.of(usuarioAutenticado, token);
    }

}
