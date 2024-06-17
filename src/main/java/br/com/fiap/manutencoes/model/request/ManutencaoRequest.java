package br.com.fiap.manutencoes.model.request;

import br.com.fiap.manutencoes.model.Manutencao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManutencaoRequest {
    @JsonProperty("id_veiculo")
    private String idVeiculo;

    @JsonProperty("quilometragem_atual")
    private long quilometragem;

    @JsonProperty("manutencoes")
    private List<Manutencao> manutencoes;
}
