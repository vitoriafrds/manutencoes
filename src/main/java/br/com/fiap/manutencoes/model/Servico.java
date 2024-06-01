package br.com.fiap.manutencoes.model;

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
public class Servico {
    @JsonProperty("id")
    private int id;

    @JsonProperty("componentes")
    private List<Integer> componentes;
}
