package br.com.wmn.greenzonemonitor.controller.aviso;

import br.com.wmn.greenzonemonitor.service.aviso.AvisoServise;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/medidas")
public class AvisoController {

    private final AvisoServise avisoServise;
}
