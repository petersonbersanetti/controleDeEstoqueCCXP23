package br.com.ccxp23.estoque.controller;


import br.com.ccxp23.estoque.exception.InvalidOperationException;
import br.com.ccxp23.estoque.exception.NoItemException;
import br.com.ccxp23.estoque.model.Equipamento;
import br.com.ccxp23.estoque.repository.EquipamentoRepository;
import br.com.ccxp23.estoque.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class EquipamentoController {


    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private EquipamentoService equipamentoService;


    @GetMapping("/home")
    public String index() {
        return "index";
    }

  @GetMapping("/equipamentos")
    public String index(Model model) {
        List<Equipamento> equipamentos = (List<Equipamento>) equipamentoRepository.findAll();
        model.addAttribute("equipamentos", equipamentos);
        return "equipamentos/index";
    }


    @GetMapping("/equipamentos/novo_equipamento")
    public String equipamento() {
        return "equipamentos/novo_equipamento";
    }

    @PostMapping("/equipamentos/criar")
    public String create(Equipamento equipamento) {
        equipamentoRepository.save(equipamento);
        return "redirect:/equipamentos";

    }

    @GetMapping("/equipamentos/{id}")
    public String find(@PathVariable Long id, Model model) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(id);
        try {
            model.addAttribute("equipamento", equipamento.get());
        } catch (Exception err) {
            return "redirect:/equipamentos";
        }
        return "/equipamentos/editar_equipamento";
    }

    @PostMapping("/equipamentos/{id}/atualizar")
    public String update(@PathVariable Long id, Equipamento equipamento) {
        if (!equipamentoRepository.existsById(id)) {
            return "redirect:/equipamentos";
        }
        equipamento.setIdRegistro(id);
        equipamentoRepository.save(equipamento);
        return "redirect:/equipamentos";
    }

    @GetMapping("/equipamentos/{id}/excluir")
    public String delete(@PathVariable Long id) {
        equipamentoRepository.deleteById(id);
        return "redirect:/equipamentos";
    }


}
