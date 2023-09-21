package br.com.wmn.greenzonemonitor.service.aviso;

import br.com.wmn.greenzonemonitor.dto.aviso.AvisoInfoDto;
import br.com.wmn.greenzonemonitor.dto.aviso.CriarAvisoDto;
import br.com.wmn.greenzonemonitor.exception.EmpresaNotfoundException;
import br.com.wmn.greenzonemonitor.mapper.aviso.AvisoInfoDtoMapper;
import br.com.wmn.greenzonemonitor.mapper.aviso.AvisoMapper;
import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import br.com.wmn.greenzonemonitor.repository.aviso.AvisoRepository;
import br.com.wmn.greenzonemonitor.repository.empresa.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvisoServise {

    private final AvisoRepository avisoRepository;
    private final EmpresaRepository empresaRepository;

    public AvisoInfoDto save(CriarAvisoDto novoAviso) {
        if (!empresaRepository.existsById(novoAviso.getEmpresaId())) {
            throw new EmpresaNotfoundException("A empresa não foi encontrada");
        }
        Aviso aviso = AvisoMapper.of(novoAviso);
        return AvisoInfoDtoMapper.of(avisoRepository.save(aviso));
    }

    public List<AvisoInfoDto> buscarPorEmpresaId(Integer empresaId) {
        if (!empresaRepository.existsById(empresaId)) {
            throw new EmpresaNotfoundException("A empresa não foi encontrada");
        }

        List<Aviso> avisos = avisoRepository.findAllByEmpresaId(empresaId);

        return avisos.stream().map(AvisoInfoDtoMapper::of).toList();
    }
}
