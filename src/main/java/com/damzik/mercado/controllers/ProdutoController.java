package com.damzik.mercado.controllers;

import com.damzik.mercado.DTOs.request.ProdutoRequestDTO;
import com.damzik.mercado.DTOs.response.ProdutoResponseDTO;
import com.damzik.mercado.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    // Listar produtos
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getListaProdutos(){
        return ResponseEntity.ok().body(produtoService.listarProdutos());
    }

    // Listar p rodutos por ID
    @GetMapping("/{produtoID}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable Long produtoID){
        return ResponseEntity.ok().body(produtoService.getProduto(produtoID));
    }
    // Cadastrar produto
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrarProduto(produtoRequestDTO));
    }
    // Atualizar produto
    @PutMapping("/{produtoID}")
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long produtoID, @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO){
        return ResponseEntity.ok().body(produtoService.updateProduto(produtoID, produtoRequestDTO));
    }
    // Deletar produto
    @DeleteMapping("/{produtoID}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long produtoID){
        produtoService.deleteProduto(produtoID);
        return ResponseEntity.noContent().build();
    }
}
