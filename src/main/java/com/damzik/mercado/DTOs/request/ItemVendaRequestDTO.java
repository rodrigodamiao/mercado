package com.damzik.mercado.DTOs.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaRequestDTO {

    @NotNull(message = "O id do Produto é obrigatório")
    private Long produtoId;

    @Min(value = 1, message = "A quantidade do item vendido deve ser maior que zero")
    private int quantidade;
}
