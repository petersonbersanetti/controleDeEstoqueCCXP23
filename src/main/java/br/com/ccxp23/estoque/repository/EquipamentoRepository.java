package br.com.ccxp23.estoque.repository;

import br.com.ccxp23.estoque.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByTxPatrimonioContainingIgnoreCase(String patrimonio);

}
