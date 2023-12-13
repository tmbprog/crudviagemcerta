
package com.vc.crudViagemCerta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //para não precisar criar gets e sets
@NoArgsConstructor //para não precisar de método construtor
@AllArgsConstructor
@Table(name = "Viagem") //para criar a tabela no banco
public class Viagem {
    
    //definir os atributos
    @Id //o @ define que é chave primária
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String viajantes;
    
    private String destino;
    
    private String periodo;
    
    private String estacao;
           
    private Integer fotos;
    
    private Integer videos;
    
    private String resenha;
    
    private Integer avaliacao;
}