package br.com.wmn.greenzonemonitor.service.medida;

import br.com.wmn.greenzonemonitor.dto.medida.MedidaInfoDto;
import br.com.wmn.greenzonemonitor.exception.MedidaNotFoundException;
import br.com.wmn.greenzonemonitor.mapper.medida.MedidaInfoDtoMapper;
import br.com.wmn.greenzonemonitor.model.medida.Medida;
import br.com.wmn.greenzonemonitor.repository.medida.MedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedidaService {

    private final MedidaRepository medidaRepository;

    public List<MedidaInfoDto> listarUltimasSeteMedidasPeloSetor(Integer setorId) {
        return medidaRepository.findTop7BySetorIdOrderByDataCriacaoDesc(setorId)
                .stream()
                .map(MedidaInfoDtoMapper::of)
                .toList();
    }

    public MedidaInfoDto buscarUltimaMedida(Integer setorId) {
        Medida medida = medidaRepository.findFirstBySetorIdOrderByDataCriacaoDesc(setorId)
                .orElseThrow(() -> new MedidaNotFoundException("A medida não foi encontrada"));

        return MedidaInfoDtoMapper.of(medida);
    }

}
