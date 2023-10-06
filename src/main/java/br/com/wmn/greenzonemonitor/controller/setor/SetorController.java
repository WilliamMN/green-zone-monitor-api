package br.com.wmn.greenzonemonitor.controller.setor;

import br.com.wmn.greenzonemonitor.dto.setor.SetorInfoDto;
import br.com.wmn.greenzonemonitor.service.setor.SetorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/setores")
public class SetorController {

    private final SetorService setorService;

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<SetorInfoDto>> listarSetoresPorEmpresaId(@PathVariable Integer empresaId) {
        List<SetorInfoDto> setores = setorService.listarSetoresPorEmpresa(empresaId);

        return ResponseEntity.status(200).body(setores);
    }
}
