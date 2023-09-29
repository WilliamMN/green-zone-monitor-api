package br.com.wmn.greenzonemonitor.mapper.medida;

import br.com.wmn.greenzonemonitor.dto.medida.MedidaInfoDto;
import br.com.wmn.greenzonemonitor.model.medida.Medida;

public class MedidaInfoDtoMapper {

    private MedidaInfoDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static MedidaInfoDto of(Medida domain) {
        return MedidaInfoDto.builder()
                .id(domain.getId())
                .dataCriacao(domain.getDataCriacao())
                .temperatura(domain.getTemperatura())
                .umidade(domain.getUmidade())
                .build();
    }
}
