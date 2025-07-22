package com.damzik.mercado.entities;

import com.damzik.mercado.DTOs.request.UsuarioRequestDTO;
import com.damzik.mercado.DTOs.response.VendaResponseDTO;
import com.damzik.mercado.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

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

    public Usuario(String email, String password, Cargo cargo){
        this.email = email;
        this.senha = password;
        this.cargo = cargo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.cargo == Cargo.GERENTE) return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"), new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
        else return List.of(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
