package br.com.ccxp23.estoque.repository;

import br.com.ccxp23.estoque.model.Equipamento;
import br.com.ccxp23.estoque.model.Omelete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OmeleteRepository extends JpaRepository<Omelete, Long> {
    List<Equipamento> findByTxPatrimonioContainingIgnoreCase(String patrimonio);

}
