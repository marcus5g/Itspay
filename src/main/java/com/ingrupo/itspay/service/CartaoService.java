package com.ingrupo.itspay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ingrupo.itspay.entity.Cartao;
import com.ingrupo.itspay.repository.CartaoRepository;


@Service
public class CartaoService {
    
    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao salvar(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> listaCartao(){
        return cartaoRepository.findAll();
    }

    public Optional<Cartao> buscarPorId(Long id){
        return cartaoRepository.findById(id);
    }

    public void removerPorId(Long id){
        cartaoRepository.deleteById(id);
    }
}
