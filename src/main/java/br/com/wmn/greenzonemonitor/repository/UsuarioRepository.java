package br.com.wmn.greenzonemonitor.repository;

import br.com.wmn.greenzonemonitor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
