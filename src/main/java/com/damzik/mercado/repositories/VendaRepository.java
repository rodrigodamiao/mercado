package com.damzik.mercado.repositories;

import com.damzik.mercado.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
