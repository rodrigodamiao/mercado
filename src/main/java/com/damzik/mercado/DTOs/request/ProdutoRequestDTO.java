package com.damzik.mercado.DTOs.request;

import com.damzik.mercado.entities.Produto;
import com.damzik.mercado.enums.CategoriaProduto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A categoria é obrigatória")
    private CategoriaProduto categoriaProduto;

    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa")
    private int quantidadeEstoque;
}
