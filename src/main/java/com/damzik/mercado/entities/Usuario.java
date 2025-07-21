package com.damzik.mercado.entities;

import com.damzik.mercado.DTOs.request.UsuarioRequestDTO;
import com.damzik.mercado.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Usuario(UsuarioRequestDTO usuarioRequestDTO){
        this.nome = usuarioRequestDTO.getNome();
        this.email = usuarioRequestDTO.getEmail();
        this.senha = usuarioRequestDTO.getSenha();
        this.cargo = usuarioRequestDTO.getCargo();
    }
}
