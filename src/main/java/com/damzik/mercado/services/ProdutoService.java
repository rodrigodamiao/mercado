package com.damzik.mercado.services;

import com.damzik.mercado.DTOs.request.ProdutoRequestDTO;
import com.damzik.mercado.DTOs.response.ProdutoResponseDTO;
import com.damzik.mercado.entities.Produto;
import com.damzik.mercado.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Listar produtos
    public List<ProdutoResponseDTO> listarProdutos(){
        return produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
    }

    // Listar produtos por ID
    public ProdutoResponseDTO getProduto(Long produtoID){
        Produto produto = produtoRepository.findById(produtoID)
                .orElseThrow(() -> new EntityNotFoundException());

        return new ProdutoResponseDTO(produto);
    }
    // Cadastrar produto
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO){
        Produto produto = new Produto(produtoRequestDTO);
        Produto salvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(salvo);
    }

    // Atualizar produto
    public ProdutoResponseDTO updateProduto(Long produtoID, ProdutoRequestDTO produtoRequestDTO){
        Produto produto = produtoRepository.findById(produtoID)
                .orElseThrow(() -> new EntityNotFoundException());

        produto.setNome(produtoRequestDTO.getNome());
        produto.setCategoria(produtoRequestDTO.getCategoriaProduto());
        produto.setPreco(produtoRequestDTO.getPreco());
        produto.setQuantidadeEstoque(produtoRequestDTO.getQuantidadeEstoque());

        Produto salvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(salvo);
    }

    // Deletar produto
    public void deleteProduto(Long produtoID){
        Produto produto = produtoRepository.findById(produtoID)
                .orElseThrow(() -> new EntityNotFoundException());

        produtoRepository.delete(produto);
    }
}
