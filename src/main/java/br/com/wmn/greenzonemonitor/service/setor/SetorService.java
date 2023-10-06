package br.com.wmn.greenzonemonitor.service.setor;

import br.com.wmn.greenzonemonitor.dto.setor.SetorInfoDto;
import br.com.wmn.greenzonemonitor.mapper.setor.SetorInfoDtoMapper;
import br.com.wmn.greenzonemonitor.repository.setor.SetorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;

    public List<SetorInfoDto> listarSetoresPorEmpresa(Integer empresaId) {
        return setorRepository.findAllByEmpresaId(empresaId).stream().map(SetorInfoDtoMapper::of).toList();
    }
}
