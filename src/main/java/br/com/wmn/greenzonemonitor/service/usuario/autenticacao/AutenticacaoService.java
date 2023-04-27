package br.com.wmn.greenzonemonitor.service.usuario.autenticacao;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioDetalhesDto;
import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import br.com.wmn.greenzonemonitor.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario informado não foi encontrado."));

        return new UsuarioDetalhesDto(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
