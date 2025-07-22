package com.damzik.mercado.services;

import com.damzik.mercado.DTOs.request.UsuarioRequestDTO;
import com.damzik.mercado.DTOs.response.UsuarioResponseDTO;
import com.damzik.mercado.DTOs.response.VendaResponseDTO;
import com.damzik.mercado.entities.Usuario;
import com.damzik.mercado.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Listar usuarios
    public List<UsuarioResponseDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.
                stream()
                .map(UsuarioResponseDTO::new)
                .toList();
    }

    // Listar usuario por ID
    public UsuarioResponseDTO getUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return new UsuarioResponseDTO(usuario);
    }

    // Cadastrar usuario
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario(usuarioRequestDTO);
        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(salvo);
    }

    // Atualizar usuario
    public UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setCargo(usuarioRequestDTO.getCargo());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(salvo);
    }

    // Deletar usuario
    public void deleteUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        usuarioRepository.delete(usuario);
    }
}
