package br.com.wmn.greenzonemonitor.repository.usuario;

import br.com.wmn.greenzonemonitor.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String username);
}
