package br.com.wmn.greenzonemonitor.model.usuario;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    @ManyToOne
    private Empresa empresa;
}

