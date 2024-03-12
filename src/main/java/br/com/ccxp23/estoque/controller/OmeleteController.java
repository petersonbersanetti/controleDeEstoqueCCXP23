package br.com.ccxp23.estoque.controller;


import br.com.ccxp23.estoque.model.Omelete;
import br.com.ccxp23.estoque.repository.OmeleteRepository;
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
public class OmeleteController {


    @Autowired
    private OmeleteRepository omeleteRepository;
    @Autowired
    private OmeleteService omeleteEquipamentoService;

  @GetMapping("/equipamentos/omelete")
    public String index(Model model) {
        List<Omelete> omeletes = (List<Omelete>) omeleteRepository.findAll();
        model.addAttribute("omeletes", omeletes);
        return "equipamentos/omelete/index";
    }

    @GetMapping("/equipamentos/omelete/novo_equipamento")
    public String equipamento() {
        return "equipamentos/omelete/novo_equipamento";
    }

    @PostMapping("/equipamentos/omelete/criar")
    public String create(Omelete omelete) {
        omeleteRepository.save(omelete);
        return "redirect:/equipamentos/omelete";

    }

    @GetMapping("/equipamentos/omelete/{id}")
    public String find(@PathVariable Long id, Model model) {
        Optional<Omelete> omelete = omeleteRepository.findById(id);
        try {
            model.addAttribute("omelete", omelete.get());
        } catch (Exception err) {
            return "redirect:/equipamentos/omelete";
        }
        return "/equipamentos/omelete/editar_equipamento";
    }

    @PostMapping("/equipamentos/omelete/{id}/atualizar")
    public String update(@PathVariable Long id, Omelete omelete) {
        if (!omeleteRepository.existsById(id)) {
            return "redirect:/equipamentos/omelete";
        }
        omelete.setIdRegistro(id);
        omeleteRepository.save(omelete);
        return "redirect:/equipamentos/omelete";
    }


    @GetMapping("/equipamentos/omelete/{id}/excluir")
    public String delete(@PathVariable Long id) {
        omeleteRepository.deleteById(id);
        return "redirect:/equipamentos/omelete";
    }
}
