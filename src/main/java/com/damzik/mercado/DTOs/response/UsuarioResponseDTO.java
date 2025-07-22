package com.damzik.mercado.DTOs.response;

import com.damzik.mercado.DTOs.request.VendaRequestDTO;
import com.damzik.mercado.entities.Usuario;
import com.damzik.mercado.entities.Venda;
import com.damzik.mercado.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Cargo cargo;

    private ResumoVendasDTO vendas;

    public UsuarioResponseDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cargo = usuario.getCargo();

        List<Venda> vendasList = usuario.getVendas();
        int quantidade = vendasList.size();
        BigDecimal precoTotal = vendasList.stream()
                .map(Venda::getPrecoTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        List<Long> ids = vendasList.stream()
                .map(Venda::getId)
                .toList();

        this.vendas = new ResumoVendasDTO(quantidade, precoTotal, ids);
    }
}