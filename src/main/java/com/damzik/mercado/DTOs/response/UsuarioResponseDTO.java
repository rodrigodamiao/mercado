package com.damzik.mercado.DTOs.response;

import com.damzik.mercado.entities.Usuario;
import com.damzik.mercado.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Cargo cargo;

    public UsuarioResponseDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cargo = usuario.getCargo();
    }
}
