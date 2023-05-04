package br.com.wmn.greenzonemonitor.controller.usuario;

import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioCriarDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioLoginDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioPerfilDto;
import br.com.wmn.greenzonemonitor.dto.usuario.UsuarioTokenDto;
import br.com.wmn.greenzonemonitor.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioPerfilDto>> listar() {
        return ResponseEntity.status(201).body(usuarioService.listar());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody UsuarioCriarDto usuarioCriarDto) {
        usuarioService.cadastrar(usuarioCriarDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticar")
    public ResponseEntity<UsuarioTokenDto> autenticar(@Valid @RequestBody UsuarioLoginDto usuarioLoginDto) {
        return ResponseEntity.status(200).body(usuarioService.autenticar(usuarioLoginDto));
    }
}
