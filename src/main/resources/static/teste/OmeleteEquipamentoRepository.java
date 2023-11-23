package br.com.ccxp23.estoque.repository;

import br.com.ccxp23.estoque.model.Equipamento;
import br.com.ccxp23.estoque.model.OmeleteEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OmeleteEquipamentoRepository extends JpaRepository<OmeleteEquipamento, Long> {
    List<Equipamento> findByTxPatrimonioContainingIgnoreCase(String patrimonio);

}
