package br.com.wmn.greenzonemonitor.controller.medida;

import br.com.wmn.greenzonemonitor.dto.medida.MedidaInfoDto;
import br.com.wmn.greenzonemonitor.service.medida.MedidaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medidas")
public class MedidaController {

    private final MedidaService medidaService;

    @GetMapping("/ultimas/{setorId}")
    public ResponseEntity<List<MedidaInfoDto>> listarUltimasMedidas(@PathVariable Integer setorId) {
        List<MedidaInfoDto> ultimasMedidas = medidaService.listarUltimasSeteMedidasPeloSetor(setorId);

        return ResponseEntity.status(200).body(ultimasMedidas);
    }

    @GetMapping("/recente/{setorId}")
    public ResponseEntity<MedidaInfoDto> buscarUltimaMedida(@PathVariable Integer setorId) {
        return ResponseEntity.status(200).body(medidaService.buscarUltimaMedida(setorId));
    }
}

