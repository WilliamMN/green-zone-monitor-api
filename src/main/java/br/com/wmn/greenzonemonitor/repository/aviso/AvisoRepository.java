package br.com.wmn.greenzonemonitor.repository.aviso;

import br.com.wmn.greenzonemonitor.model.aviso.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
}
