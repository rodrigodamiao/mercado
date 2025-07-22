package com.damzik.mercado.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumoVendasDTO {
    private int quantidade;
    private BigDecimal precoTotal;
    private List<Long> ids;
}