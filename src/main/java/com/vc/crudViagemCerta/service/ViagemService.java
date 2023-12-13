package com.vc.crudViagemCerta.service;

import com.vc.crudViagemCerta.model.Viagem;
import com.vc.crudViagemCerta.repository.ViagemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViagemService {
    
    @Autowired
    ViagemRepository viagemRepository;
    
    public Viagem criar (Viagem vgm){
        vgm.setId(null);
        viagemRepository.save(vgm);
        return vgm;
               
    }
    
    public List<Viagem> listarTodos(){
        return viagemRepository.findAll();
    }
    
    public Viagem bucarPorId (Integer id){
        return viagemRepository.findById(id).orElseThrow();
    }
    
    public void excluir (Integer id){
        Viagem viagemEncontrada = bucarPorId(id);
        viagemRepository.deleteById(viagemEncontrada.getId());
    }
    
    public Viagem atualizar (Integer id, Viagem viagemEnviada){
        Viagem viagemEncontrada = bucarPorId(id);
        viagemEncontrada.setViajantes(viagemEnviada.getViajantes());
        viagemEncontrada.setDestino(viagemEnviada.getDestino());
        viagemEncontrada.setPeriodo(viagemEnviada.getPeriodo());
        viagemEncontrada.setEstacao(viagemEnviada.getEstacao());
        viagemEncontrada.setFotos(viagemEnviada.getFotos());
        viagemEncontrada.setVideos(viagemEnviada.getVideos());
        viagemEncontrada.setResenha(viagemEnviada.getResenha());
        viagemEncontrada.setAvaliacao(viagemEnviada.getAvaliacao());
        viagemRepository.save(viagemEncontrada);
        return viagemEncontrada;
    }
}
