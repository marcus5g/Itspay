package com.ingrupo.itspay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* MainController
*/
@RestController
public class MainController {

    @GetMapping(path = "/api/status")
    public String getMethodName() {
        return "Ativo";
    }
    
}
