package br.com.fiap.manutencoes.handler;

import br.com.fiap.manutencoes.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<Object> handler(HttpClientErrorException error) {
        return ResponseEntity.status(401).build();
    }

}
