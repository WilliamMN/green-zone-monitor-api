package br.com.wmn.greenzonemonitor.dto.aviso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AvisoInfoDto {

    private Integer id;

    private String titulo;

    private String descricao;

    private Integer empresaId;
}
