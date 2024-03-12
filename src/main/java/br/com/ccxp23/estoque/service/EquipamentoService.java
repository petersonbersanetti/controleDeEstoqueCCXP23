package br.com.ccxp23.estoque.service;

import br.com.ccxp23.estoque.model.Equipamento;
import br.com.ccxp23.estoque.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> obterTodosEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public List<Equipamento> filtrarEquipamentosPorPatrimonio(String patrimonio) {
        return equipamentoRepository.findByTxPatrimonioContainingIgnoreCase(patrimonio);
    }
}
