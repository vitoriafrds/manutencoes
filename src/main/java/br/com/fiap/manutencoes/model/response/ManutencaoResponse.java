package br.com.fiap.manutencoes.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManutencaoResponse {
    private long quilometragem;
    private String tipo;
    private String componente;

    @JsonProperty("data_execucao")
    private LocalDateTime data;
}
