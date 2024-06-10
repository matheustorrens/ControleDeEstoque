package br.com.controledeestoque.controledeestoque.produtos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "produto_model")
public class ProdutosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome_produto;
    private String categoria_produto;
    private String qtde_produto;
    private double validade_produto;
    private String fabricacao_produto;
    private String data_entrada;
    private String data_saida;
    private String preco_mercado;
    private String preco_venda;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

}
