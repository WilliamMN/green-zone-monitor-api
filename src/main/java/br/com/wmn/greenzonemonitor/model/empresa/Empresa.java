package br.com.wmn.greenzonemonitor.model.empresa;

import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String razaoSocial;

    private String cnpj;

    @OneToMany(mappedBy = "empresa")
    private List<Aviso> avisos;
}
