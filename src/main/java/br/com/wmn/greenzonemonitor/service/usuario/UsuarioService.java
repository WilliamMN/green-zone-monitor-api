package br.com.wmn.greenzonemonitor.service.usuario;

import br.com.wmn.greenzonemonitor.config.security.jwt.GerenciadorTokenJwt;
import br.com.wmn.greenzonemonitor.dto.usuario.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioLoginDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.exception.UsuarioConflitException;
import br.com.wmn.greenzonemonitor.exception.UsuarioNotFoundException;
import br.com.wmn.greenzonemonitor.mapper.usuario.UsuarioMapper;
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

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioTokenDtoMapper usuarioTokenDtoMapper;

    private final PasswordEncoder passwordEncoder;

    private final GerenciadorTokenJwt gerenciadorTokenJwt;

    private final AuthenticationManager authenticationManager;

    public void cadastrar(CriarUsuarioDto criarUsuarioDto) {

        boolean emailExiste = usuarioRepository.existsByEmail(criarUsuarioDto.getEmail());

        if (emailExiste) {
            throw new UsuarioConflitException("O usuário com o email informado já existe.");
        }

        criarUsuarioDto.setSenha(passwordEncoder.encode(criarUsuarioDto.getSenha()));

        usuarioRepository.save(usuarioMapper.of(criarUsuarioDto));
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {
        final UsernamePasswordAuthenticationToken credentials =
                new UsernamePasswordAuthenticationToken(usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                .orElseThrow(UsuarioNotFoundException::new);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return usuarioTokenDtoMapper.of(usuarioAutenticado, token);
    }

}
