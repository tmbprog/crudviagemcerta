package com.vc.crudViagemCerta.controller;

import com.vc.crudViagemCerta.model.Viagem;
import com.vc.crudViagemCerta.service.ViagemService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class viagemController {
    
    @Autowired
    ViagemService viagemService;
    
    @GetMapping("/") //definição a rota da url
    public String inicio(){               
        return "index"; //indica o arquivo que será chamado
    }
    
    
    @GetMapping("/cadastrar-viagem")
    public String cadastrar(Model model){
        model.addAttribute("viagem", new Viagem());
        return "cadastrar-viagem";
    }
    
    @GetMapping("/detalhar-viagens")
    public String detalhar(Model model){
                
        model.addAttribute("lista", viagemService.listarTodos()); 
               
        return "detalhar-viagens";
    }
    
    
    @GetMapping("/alterar-viagem")
    public String alterarviagem (Model model, @RequestParam String id){
        Integer idViagem = Integer.parseInt(id);
        Viagem viagemEncontraa = viagemService.bucarPorId(idViagem);
        model.addAttribute("viagem", viagemEncontraa);
        return "alterar-viagem";
    }
    
    @GetMapping("/excluir")
    public String excluirviagem (Model model, @RequestParam String id){
        Integer idViagem = Integer.parseInt(id);        
        viagemService.excluir(idViagem);
        
        return "redirect:/detalhar-viagens";
    }
    
    @PostMapping("/cadastrar-viagem")
    public String processarFormulario(@ModelAttribute Viagem viagem, Model model){
        
        //Pra alteração
        if (viagem.getId() != null){
            viagemService.atualizar(viagem.getId(), viagem);
        }else{
            //para nova inclusão
            viagemService.criar(viagem);            
        }
        
        return "redirect:/detalhar-viagens";
    }
}
