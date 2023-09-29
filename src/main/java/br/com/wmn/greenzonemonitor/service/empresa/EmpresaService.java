package br.com.wmn.greenzonemonitor.service.empresa;

import br.com.wmn.greenzonemonitor.exception.EmpresaNotFoundException;
import br.com.wmn.greenzonemonitor.repository.empresa.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public void empresaExistePeloId(Integer empresaId) {
        if (!empresaRepository.existsById(empresaId)) {
            throw new EmpresaNotFoundException("A empresa não foi encontrada");
        }
    }
}
