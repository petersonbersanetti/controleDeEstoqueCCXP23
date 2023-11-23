package br.com.ccxp23.estoque.controller;


import br.com.ccxp23.estoque.model.OmeleteEquipamento;
import br.com.ccxp23.estoque.repository.OmeleteEquipamentoRepository;
import br.com.ccxp23.estoque.service.OmeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class OmeleteEquipamentoController {


    @Autowired
    private OmeleteEquipamentoRepository omeleteEquipamentoRepository;
    @Autowired
    private OmeleteService omeleteEquipamentoService;

  @GetMapping("/equipamentos/omelete")
    public String index(Model model) {
        List<OmeleteEquipamento> omeleteEquipamentos = (List<OmeleteEquipamento>) omeleteEquipamentoRepository.findAll();
        model.addAttribute("omeleteEquipamentos", omeleteEquipamentos);
        return "equipamentos/omelete/index";
    }

 /*
    @GetMapping("/equipamentos/filtrar")
    public String filtrarEquipamentos(@RequestParam("filtro") String filtro, Model model) {
        List<Equipamento> equipamentosFiltrados = equipamentoService.filtrarEquipamentosPorPatrimonio(filtro);
        model.addAttribute("equipamentos", equipamentosFiltrados);
        return "fragmento/equipamentos :: equipamentos";
    }
 */

    @GetMapping("/equipamentos/omelete/novo_equipamento")
    public String equipamento() {
        return "equipamentos/omelete/novo_equipamento";
    }

    @PostMapping("/equipamentos/omelete/criar")
    public String create(OmeleteEquipamento omeleteEquipamento) {
        omeleteEquipamentoRepository.save(omeleteEquipamento);
        return "redirect:/equipamentos";

    }

    @GetMapping("/equipamentos/omelete/{id}")
    public String find(@PathVariable Long id, Model model) {
        Optional<OmeleteEquipamento> omeleteEquipamento = omeleteEquipamentoRepository.findById(id);
        try {
            model.addAttribute("omeleteEquipamento", omeleteEquipamento.get());
        } catch (Exception err) {
            return "redirect:/equipamentos/omelete";
        }
        return "/equipamentos/omelete/editar_equipamento";
    }

    @PostMapping("/equipamentos/omelete/{id}/atualizar")
    public String update(@PathVariable Long id, OmeleteEquipamento omeleteEquipamento) {
        if (!omeleteEquipamentoRepository.existsById(id)) {
            return "redirect:/equipamentos/omelete";
        }
        omeleteEquipamento.setIdRegistro(id);
        omeleteEquipamentoRepository.save(omeleteEquipamento);
        return "redirect:/equipamentos/omelete";
    }

    @GetMapping("/equipamentos/omelete/{id}/excluir")
    public String delete(@PathVariable Long id) {
        omeleteEquipamentoRepository.deleteById(id);
        return "redirect:/equipamentos/omelete";
    }


}
