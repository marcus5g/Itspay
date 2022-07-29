package com.ingrupo.itspay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Builder
 @Entity


public class Cartao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numero", nullable = false, length= 16)
    private String numero;

    @Column(name = "nomeUsuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "codigoSeguranca", nullable = false, length = 3)
    private String codigoSeguranca;

    @Column(name = "dataValidade", nullable = false, length = 6)
    private String dataValidade;
    
}
