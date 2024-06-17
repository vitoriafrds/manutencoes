package br.com.fiap.manutencoes.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    @JsonProperty("client_id")
    private String client_id;

    @JsonProperty("exp")
    private long expiration;
}
