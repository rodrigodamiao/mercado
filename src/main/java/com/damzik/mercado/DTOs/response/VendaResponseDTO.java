package com.damzik.mercado.DTOs.response;

import com.damzik.mercado.entities.Venda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponseDTO {

    private Long id;
    private Long usuarioId;
    private LocalDateTime dataHoraDaVenda;
    private BigDecimal precoTotal;
    private List<ItemVendaResponseDTO> produtos;

    public VendaResponseDTO(Venda venda){
        this.id = venda.getId();
        this.usuarioId = venda.getUsuario().getId();
        this.dataHoraDaVenda = venda.getDataHoraDaVenda();
        this.precoTotal = venda.getPrecoTotal();
        this.produtos = venda.getProdutos().stream().map(ItemVendaResponseDTO::new).toList();
    }
}
