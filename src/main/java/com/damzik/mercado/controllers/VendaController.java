package com.damzik.mercado.controllers;

import com.damzik.mercado.DTOs.request.VendaRequestDTO;
import com.damzik.mercado.DTOs.response.VendaResponseDTO;
import com.damzik.mercado.services.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    // Listar vendas
    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> getVendas(){
        return ResponseEntity.ok().body(vendaService.getListaVendas());
    }

    // Buscar venda por id
    @GetMapping("/{vendaId}")
    public ResponseEntity<VendaResponseDTO> getVendaById(@PathVariable Long vendaId){
        return ResponseEntity.ok().body(vendaService.getVendaById(vendaId));
    }

    // Registrar venda
    @PostMapping
    public ResponseEntity<VendaResponseDTO> registrarVenda(@RequestBody @Valid VendaRequestDTO vendaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.registrarVenda(vendaRequestDTO));
    }

    // Buscar vendas do usuario pelo id
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<VendaResponseDTO>> getUserVendas(@PathVariable Long userId){
        return ResponseEntity.ok().body(vendaService.getUserVendas(userId));
    }
}
