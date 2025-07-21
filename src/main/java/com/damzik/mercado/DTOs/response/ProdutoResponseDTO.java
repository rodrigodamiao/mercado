package com.damzik.mercado.DTOs.response;

import com.damzik.mercado.entities.Produto;
import com.damzik.mercado.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private CategoriaProduto categoriaProduto;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public ProdutoResponseDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.categoriaProduto = produto.getCategoria();
        this.preco = produto.getPreco();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }
}
