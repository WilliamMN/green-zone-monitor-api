package br.com.wmn.greenzonemonitor.repository.aviso;

import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisoRepository extends JpaRepository<Aviso, Integer> {
    List<Aviso> findAllByEmpresaId(Integer empresaId);
}
