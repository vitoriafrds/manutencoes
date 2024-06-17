package br.com.fiap.manutencoes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.manutencoes.model.request.TokenValidationRequest;
import br.com.fiap.manutencoes.model.response.TokenValidationResponse;

@Service
public class TokenValidationService {

    public boolean isValid(String token) {
        RestTemplate restTemplate = new RestTemplate();
        String validationServiceUrl = "http://localhost:5000/verify-token";


        try {
            TokenValidationResponse response = restTemplate.postForObject(validationServiceUrl,
                    new TokenValidationRequest(token),
                    TokenValidationResponse.class);

            return response.isValid();
        } catch (Exception e) {
            throw e;
        }
    }
}
