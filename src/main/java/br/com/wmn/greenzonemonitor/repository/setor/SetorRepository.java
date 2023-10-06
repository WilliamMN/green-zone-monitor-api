package br.com.wmn.greenzonemonitor.repository.setor;

import br.com.wmn.greenzonemonitor.model.setor.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    List<Setor> findAllByEmpresaId(Integer empresaId);
}
