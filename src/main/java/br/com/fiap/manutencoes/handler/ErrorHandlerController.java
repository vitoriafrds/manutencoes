package br.com.fiap.manutencoes.handler;

import br.com.fiap.manutencoes.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<DataError> handler(HttpClientErrorException error) {
        return ResponseEntity.status(401)
                .body(new DataError("Invalid or expired token", LocalDateTime.now()));
    }

}
