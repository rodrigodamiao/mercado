package com.damzik.mercado.DTOs.response;

import com.damzik.mercado.entities.ItemVenda;
import com.damzik.mercado.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaResponseDTO {

    private Long produtoId;
    private String nomeProduto;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemVendaResponseDTO(ItemVenda itemVenda){
        this.produtoId = itemVenda.getProduto().getId();
        this.nomeProduto = itemVenda.getProduto().getNome();
        this.quantidade = itemVenda.getQuantidade();
        this.precoUnitario = itemVenda.getPrecoUnitario();
    }
}
