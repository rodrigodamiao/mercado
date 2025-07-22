package com.damzik.mercado.services;

import com.damzik.mercado.DTOs.request.ItemVendaRequestDTO;
import com.damzik.mercado.DTOs.request.VendaRequestDTO;
import com.damzik.mercado.DTOs.response.ItemVendaResponseDTO;
import com.damzik.mercado.DTOs.response.ProdutoResponseDTO;
import com.damzik.mercado.DTOs.response.VendaResponseDTO;
import com.damzik.mercado.entities.ItemVenda;
import com.damzik.mercado.entities.Produto;
import com.damzik.mercado.entities.Usuario;
import com.damzik.mercado.entities.Venda;
import com.damzik.mercado.repositories.ProdutoRepository;
import com.damzik.mercado.repositories.UsuarioRepository;
import com.damzik.mercado.repositories.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;

    // Listar vendas
    public List<VendaResponseDTO> getListaVendas(){
        return vendaRepository.findAll().stream().map(VendaResponseDTO::new).toList();
    }

    // Buscar venda por Id
    public VendaResponseDTO getVendaById(Long id){
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return new VendaResponseDTO(venda);
    }

    // Registrar venda
    public VendaResponseDTO registrarVenda(VendaRequestDTO vendaRequestDTO){
        Venda venda = new Venda();
        Usuario usuario = usuarioRepository.findById(vendaRequestDTO.getUsuarioId())
                        .orElseThrow(EntityNotFoundException::new);

        // Criar uma lista de ItemVenda a partir do ItemVendaRequestDTO
        List<ItemVenda> itemVendas = new ArrayList<>();

        for(ItemVendaRequestDTO itemVendaRequestDTO : vendaRequestDTO.getProdutos()){

            Produto produto = produtoRepository.findById(itemVendaRequestDTO.getProdutoId())
                    .orElseThrow(EntityNotFoundException::new);

            if(itemVendaRequestDTO.getQuantidade() > produto.getQuantidadeEstoque()){
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemVendaRequestDTO.getQuantidade());
            produtoRepository.save(produto);

            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(itemVendaRequestDTO.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());

            itemVendas.add(item);
        }

        BigDecimal precoTotal = itemVendas.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        venda.setDataHoraDaVenda(LocalDateTime.now());
        venda.setUsuario(usuario);
        venda.setProdutos(itemVendas);
        venda.setPrecoTotal(precoTotal);

        Venda salvo = vendaRepository.save(venda);

        return new VendaResponseDTO(salvo);
    }

    // Buscar vendas do usuario pelo id
    public List<VendaResponseDTO> getUserVendas(Long userId){
        Usuario user = usuarioRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);

        List<VendaResponseDTO> vendas = user.getVendas().stream().map(VendaResponseDTO::new).toList();

        return vendas;
    }

}
