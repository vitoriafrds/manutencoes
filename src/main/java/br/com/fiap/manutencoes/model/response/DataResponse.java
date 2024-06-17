package br.com.fiap.manutencoes.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse<T> {
    private T data;

    public static <T> DataResponse<T> of(T data) {
        return new DataResponse<>(data);
    }
}
