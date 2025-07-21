package com.damzik.mercado.DTOs.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequestDTO {

    @NotNull(message = "O id do usuário não pode ser nulo")
    private Long usuarioId;

    @NotEmpty(message = "A lista de produtos vendidos não pode ser nula")
    private List<ItemVendaRequestDTO> produtos;

}
