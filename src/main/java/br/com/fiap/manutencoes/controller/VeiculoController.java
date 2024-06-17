package br.com.fiap.manutencoes.controller;

import br.com.fiap.manutencoes.model.response.DataResponse;
import br.com.fiap.manutencoes.model.response.VeiculoResponse;
import br.com.fiap.manutencoes.service.VeiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {
    private VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/{id}/manutencoes")
    public ResponseEntity<DataResponse<VeiculoResponse>> consultar(@PathVariable String id) {
        Optional<VeiculoResponse> veiculo = service.consultarManutencoes(id);

        return veiculo.map(veiculoResponse -> ResponseEntity.ok(DataResponse.of(veiculoResponse)))
                .orElseGet(() -> ResponseEntity.noContent().build());

    }
}
