package br.com.fiap.manutencoes.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {
    @JsonProperty("id_veiculo")
    private String id;

    @JsonProperty("manutencoes")
    private List<ManutencaoResponse> manutencoes;
}
