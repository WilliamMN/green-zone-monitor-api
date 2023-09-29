package br.com.wmn.greenzonemonitor.repository.medida;

import br.com.wmn.greenzonemonitor.model.medida.Medida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedidaRepository extends JpaRepository<Medida, Integer> {

    List<Medida> findTop7BySetorIdOrderByDataCriacaoDesc(Integer setorId);

    Optional<Medida> findFirstBySetorIdOrderByDataCriacaoDesc(Integer setorId);
}
