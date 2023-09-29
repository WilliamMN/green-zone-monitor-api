package br.com.wmn.greenzonemonitor.service.aviso;

import br.com.wmn.greenzonemonitor.dto.aviso.AvisoInfoDto;
import br.com.wmn.greenzonemonitor.dto.aviso.CriarAvisoDto;
import br.com.wmn.greenzonemonitor.exception.EmpresaNotFoundException;
import br.com.wmn.greenzonemonitor.mapper.aviso.AvisoInfoDtoMapper;
import br.com.wmn.greenzonemonitor.mapper.aviso.AvisoMapper;
import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import br.com.wmn.greenzonemonitor.repository.aviso.AvisoRepository;
import br.com.wmn.greenzonemonitor.repository.empresa.EmpresaRepository;
import br.com.wmn.greenzonemonitor.service.empresa.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvisoServise {

    private final AvisoRepository avisoRepository;
    private final EmpresaService empresaService;

    public AvisoInfoDto save(CriarAvisoDto novoAviso) {
        empresaService.empresaExistePeloId(novoAviso.getEmpresaId());

        Aviso aviso = AvisoMapper.of(novoAviso);
        return AvisoInfoDtoMapper.of(avisoRepository.save(aviso));
    }

    public List<AvisoInfoDto> listarPorEmpresaId(Integer empresaId) {
        empresaService.empresaExistePeloId(empresaId);

        List<Aviso> avisos = avisoRepository.findAllByEmpresaId(empresaId);

        return avisos.stream().map(AvisoInfoDtoMapper::of).toList();
    }
}
