package br.com.fiap.manutencoes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manutencao {
    @JsonProperty("id_veiculo")
    private String idVeiculo;

    @JsonProperty("quilometragem_atual")
    private long quilometragemAtual;

    @JsonProperty("servico")
    private Servico servico;
}
