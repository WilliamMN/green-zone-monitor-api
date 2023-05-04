package br.com.wmn.greenzonemonitor.service.aviso;

import br.com.wmn.greenzonemonitor.repository.aviso.AvisoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvisoServise {

    private final AvisoRepository avisoRepository;
}
