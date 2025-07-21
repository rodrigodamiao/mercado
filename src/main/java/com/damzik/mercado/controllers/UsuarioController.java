package com.damzik.mercado.controllers;

import com.damzik.mercado.DTOs.request.UsuarioRequestDTO;
import com.damzik.mercado.DTOs.response.UsuarioResponseDTO;
import com.damzik.mercado.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Listar usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getListaUsuarios(){
        return ResponseEntity.ok().body(usuarioService.listarUsuarios());
    }

    // Listar usuario por ID
    @GetMapping("/{userID}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long userID){
        return ResponseEntity.ok().body(usuarioService.getUsuario(userID));
    }

    // Cadastrar usuario
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuarioRequestDTO));
    }

    // Atualizar usuario
    @PutMapping("/{userID}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable Long userID, @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok().body(usuarioService.updateUsuario(userID, usuarioRequestDTO));
    }

    // Deletar usuario
    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long userID){
        usuarioService.deleteUsuario(userID);
        return ResponseEntity.noContent().build();
    }
}
