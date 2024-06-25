package br.com.fiap.manutencoes.controller;

import br.com.fiap.manutencoes.model.response.DataResponse;
import br.com.fiap.manutencoes.model.response.VeiculoResponse;
import br.com.fiap.manutencoes.service.ChaveService;
import br.com.fiap.manutencoes.service.VeiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {
    private VeiculoService service;
    private ChaveService chaveService;

    @Autowired
    public VeiculoController(VeiculoService service, ChaveService chaveService) {
        this.service = service;
        this.chaveService = chaveService;
    }

    @GetMapping("/{id}/manutencoes")
    public ResponseEntity<DataResponse<VeiculoResponse>> consultar(@PathVariable String id,
                                                                   @RequestHeader String chave) {

        if (!chaveService.chaveValida(chave)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<VeiculoResponse> veiculo = service.consultarManutencoes(id);

        return veiculo.map(veiculoResponse -> ResponseEntity.ok(DataResponse.of(veiculoResponse)))
                .orElseGet(() -> ResponseEntity.noContent().build());

    }
}
