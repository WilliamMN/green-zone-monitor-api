package br.com.wmn.greenzonemonitor.controller.aviso;

import br.com.wmn.greenzonemonitor.dto.aviso.AvisoInfoDto;
import br.com.wmn.greenzonemonitor.dto.aviso.CriarAvisoDto;
import br.com.wmn.greenzonemonitor.service.aviso.AvisoServise;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/avisos")
public class AvisoController {

    private final AvisoServise avisoServise;

    @PostMapping
    public ResponseEntity<AvisoInfoDto> criarAviso(@Valid @RequestBody CriarAvisoDto novoAviso) {
        return ResponseEntity.status(201).body(avisoServise.save(novoAviso));
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<AvisoInfoDto>> buscarPorEmpresa(@PathVariable Integer empresaId) {
        return ResponseEntity.status(200).body(avisoServise.buscarPorEmpresaId(empresaId));
    }
}
