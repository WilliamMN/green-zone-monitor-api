package br.com.wmn.greenzonemonitor.controller;

import br.com.wmn.greenzonemonitor.dto.AutenticarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.CriarUsuarioDto;
import br.com.wmn.greenzonemonitor.dto.UsuarioDetalhadoDto;
import br.com.wmn.greenzonemonitor.model.Usuario;
import br.com.wmn.greenzonemonitor.service.UsuarioService;
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

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.status(200).body(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CriarUsuarioDto criarUsuarioDto) {
        usuarioService.cadastrar(criarUsuarioDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticar")
    public ResponseEntity<UsuarioDetalhadoDto> autenticar(@Valid @RequestBody AutenticarUsuarioDto autenticarUsuarioDto) {
        return ResponseEntity.status(200).body(usuarioService.autenticar(autenticarUsuarioDto));
    }
}
