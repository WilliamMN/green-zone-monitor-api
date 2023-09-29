package br.com.wmn.greenzonemonitor.dto.medida;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class MedidaInfoDto {

    private Integer id;

    private Double umidade;

    private Double temperatura;

    private LocalDateTime dataCriacao;
}
