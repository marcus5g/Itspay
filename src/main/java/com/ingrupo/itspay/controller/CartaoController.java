package com.ingrupo.itspay.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ingrupo.itspay.entity.Cartao;
import com.ingrupo.itspay.service.CartaoService;

@RestController
@RequestMapping("/cartões")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao salvar(@RequestBody Cartao cartao){
        return cartaoService.salvar(cartao);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cartao> listaCartao(){
        return cartaoService.listaCartao();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cartao buscarCartaoPorId(@PathVariable("id") Long id){
        return cartaoService.buscarPorId(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(reason = "Produto deletado com sucesso!", value = HttpStatus.OK)
    public void  removerCartao(@PathVariable("id") Long id){
        cartaoService.buscarPorId(id)
        .map(cartao -> {
            cartaoService.removerPorId(cartao.getId());
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado."));
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(reason = "Produto alterado com sucesso!", code = HttpStatus.OK)
    public void atualizarCartao(@PathVariable("id") Long id, @RequestBody Cartao cartao){
        cartaoService.buscarPorId(id)
        .map(cartaoBase -> {
            modelMapper.map(cartao, cartaoBase);
            cartaoService.salvar(cartaoBase);
            return cartao;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado."));
    }

}
