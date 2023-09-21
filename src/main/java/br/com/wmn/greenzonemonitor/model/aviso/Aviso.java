package br.com.wmn.greenzonemonitor.model.aviso;

import br.com.wmn.greenzonemonitor.model.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String descricao;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Empresa empresa;
}
