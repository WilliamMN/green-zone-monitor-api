package br.com.wmn.greenzonemonitor.dto.setor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SetorInfoDto {

    private Integer id;
    private String descricao;
}
