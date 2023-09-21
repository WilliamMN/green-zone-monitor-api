package br.com.wmn.greenzonemonitor.mapper.aviso;

import br.com.wmn.greenzonemonitor.dto.aviso.CriarAvisoDto;
import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import br.com.wmn.greenzonemonitor.model.empresa.Empresa;

public class AvisoMapper {

    private AvisoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Aviso of(CriarAvisoDto dto) {
        return Aviso.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .empresa(Empresa.builder().id(dto.getEmpresaId()).build())
                .build();
    }
}
