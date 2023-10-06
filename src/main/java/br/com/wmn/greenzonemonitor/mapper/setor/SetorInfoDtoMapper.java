package br.com.wmn.greenzonemonitor.mapper.setor;

import br.com.wmn.greenzonemonitor.dto.setor.SetorInfoDto;
import br.com.wmn.greenzonemonitor.model.setor.Setor;

public class SetorInfoDtoMapper {

    private SetorInfoDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static SetorInfoDto of(Setor domain) {
        return SetorInfoDto.builder()
                .id(domain.getId())
                .descricao(domain.getDescricao())
                .build();
    }
}
