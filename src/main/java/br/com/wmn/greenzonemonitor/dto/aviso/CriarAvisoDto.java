package br.com.wmn.greenzonemonitor.dto.aviso;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CriarAvisoDto {

    @NotNull(message = "Campo titulo não pode ser nula")
    @NotEmpty(message = "Campo titulo não pode ser vazia")
    private String titulo;

    @NotNull(message = "Campo descricao não pode ser nula")
    @NotEmpty(message = "Campo descricao não pode ser vazia")
    private String descricao;

    @NotNull(message = "Campo empresaId não pode ser nula")
    private Integer empresaId;
}
