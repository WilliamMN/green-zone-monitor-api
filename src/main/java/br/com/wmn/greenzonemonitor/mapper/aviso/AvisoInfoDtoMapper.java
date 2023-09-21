package br.com.wmn.greenzonemonitor.mapper.aviso;

import br.com.wmn.greenzonemonitor.dto.aviso.AvisoInfoDto;
import br.com.wmn.greenzonemonitor.model.aviso.Aviso;

public class AvisoInfoDtoMapper {

    private AvisoInfoDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static AvisoInfoDto of(Aviso domain) {
        return AvisoInfoDto.builder()
                .id(domain.getId())
                .titulo(domain.getTitulo())
                .descricao(domain.getDescricao())
                .empresaId(domain.getEmpresa().getId())
                .build();
    }

}
