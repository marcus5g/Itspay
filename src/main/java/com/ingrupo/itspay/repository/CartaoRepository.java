package com.ingrupo.itspay.repository;

import com.ingrupo.itspay.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    
}
