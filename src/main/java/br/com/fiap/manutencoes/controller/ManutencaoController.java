package br.com.fiap.manutencoes.controller;

import br.com.fiap.manutencoes.model.Manutencao;
import br.com.fiap.manutencoes.repository.entity.ManutencaoEntity;
import br.com.fiap.manutencoes.service.ManutencaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public void registrar(@RequestBody Manutencao manutencao) {
        service.registrar(manutencao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoEntity> registrar(@PathVariable int id) {
        Optional<ManutencaoEntity> manutencao = service.consultar(id);

        return manutencao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());

    }
}
