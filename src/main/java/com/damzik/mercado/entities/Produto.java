package com.damzik.mercado.entities;

import com.damzik.mercado.DTOs.request.ProdutoRequestDTO;
import com.damzik.mercado.enums.CategoriaProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    private int quantidadeEstoque;

    public Produto(ProdutoRequestDTO produtoRequestDTO){
        this.nome = produtoRequestDTO.getNome();
        this.categoria = produtoRequestDTO.getCategoriaProduto();
        this.preco = produtoRequestDTO.getPreco();
        this.quantidadeEstoque = produtoRequestDTO.getQuantidadeEstoque();
    }
}
