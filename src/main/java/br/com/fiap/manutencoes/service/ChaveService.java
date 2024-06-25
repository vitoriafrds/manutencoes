package br.com.fiap.manutencoes.service;

import br.com.fiap.manutencoes.repository.ChaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChaveService {
    private ChaveRepository repository;

    @Autowired
    public ChaveService(ChaveRepository repository) {
        this.repository = repository;
    }

    public boolean chaveValida(String chave) {
        return repository.existsById(UUID.fromString(chave));
    }
}
