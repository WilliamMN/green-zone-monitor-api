package br.com.wmn.greenzonemonitor.model.usuario;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Aviso> avisos;
}

