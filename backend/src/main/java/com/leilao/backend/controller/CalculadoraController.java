package com.leilao.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculadoraController {
    @GetMapping("/somar")
    public Integer somar(@RequestParam("v1") Integer valor1,
            @RequestParam("v2") Integer valor2) {
        return valor1 + valor2;
    }
}
