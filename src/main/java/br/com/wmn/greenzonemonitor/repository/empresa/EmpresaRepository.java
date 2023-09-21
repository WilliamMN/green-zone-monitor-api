package br.com.wmn.greenzonemonitor.repository.empresa;

import br.com.wmn.greenzonemonitor.model.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
