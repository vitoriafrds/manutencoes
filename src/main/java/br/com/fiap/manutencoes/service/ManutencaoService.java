package br.com.fiap.manutencoes.service;

import br.com.fiap.manutencoes.model.Manutencao;
import br.com.fiap.manutencoes.repository.ManutencaoRepository;
import br.com.fiap.manutencoes.repository.entity.ComponenteEntity;
import br.com.fiap.manutencoes.repository.entity.ManutencaoEntity;
import br.com.fiap.manutencoes.repository.entity.ServicoEntity;
import br.com.fiap.manutencoes.repository.entity.VeiculoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManutencaoService {
    private ManutencaoRepository repository;

    @Autowired
    public ManutencaoService(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public void registrar(Manutencao manutencao) {
        ManutencaoEntity entity = new ManutencaoEntity();
        entity.setDataHora(LocalDateTime.now());
        entity.setVeiculo(new VeiculoEntity(manutencao.getIdVeiculo()));

        ServicoEntity servicoEntity = new ServicoEntity();
        servicoEntity.setId(manutencao.getServico().getId());
        entity.setServico(servicoEntity);

        entity.setComponentes(manutencao.getServico().getComponentes().stream().map(id -> {
            ComponenteEntity componente = new ComponenteEntity();
            componente.setId(id);

            return componente;
        }).collect(Collectors.toList()));

        repository.save(entity);
    }

    public Optional<ManutencaoEntity> consultar(int id) {
        return repository.findById(id);
    }
}
