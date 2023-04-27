package br.com.wmn.greenzonemonitor.controller.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioLoginDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CriarUsuarioDto criarUsuarioDto) {
        usuarioService.cadastrar(criarUsuarioDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@Valid @RequestBody UsuarioLoginDto usuarioLoginDto) {
        return ResponseEntity.status(200).body(usuarioService.autenticar(usuarioLoginDto));
    }
}
