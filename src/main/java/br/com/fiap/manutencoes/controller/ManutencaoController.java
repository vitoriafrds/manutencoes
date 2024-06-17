package br.com.fiap.manutencoes.controller;

import br.com.fiap.manutencoes.model.request.ManutencaoRequest;
import br.com.fiap.manutencoes.service.ManutencaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/manutencoes")
public class ManutencaoController {
    private ManutencaoService service;

    @Autowired
    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @PostMapping
    public void registrar(@RequestBody ManutencaoRequest manutencao) {
        service.registrar(manutencao);
    }
}
