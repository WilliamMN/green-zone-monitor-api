package br.com.wmn.greenzonemonitor.model.medida;

import br.com.wmn.greenzonemonitor.model.setor.Setor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double umidade;

    private Double temperatura;

    private LocalDateTime dataCriacao;

    @ManyToOne
    private Setor setor;

}
