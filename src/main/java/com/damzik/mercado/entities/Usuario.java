package com.damzik.mercado.entities;

import com.damzik.mercado.DTOs.request.UsuarioRequestDTO;
import com.damzik.mercado.DTOs.response.VendaResponseDTO;
import com.damzik.mercado.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venda> vendas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Usuario(UsuarioRequestDTO usuarioRequestDTO){
        this.nome = usuarioRequestDTO.getNome();
        this.email = usuarioRequestDTO.getEmail();
        this.senha = usuarioRequestDTO.getSenha();
        this.cargo = usuarioRequestDTO.getCargo();
    }
}
