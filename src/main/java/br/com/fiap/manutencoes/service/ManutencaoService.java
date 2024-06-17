package br.com.fiap.manutencoes.service;

import br.com.fiap.manutencoes.model.request.ManutencaoRequest;
import br.com.fiap.manutencoes.repository.ManutencaoRepository;
import br.com.fiap.manutencoes.repository.entity.ComponenteEntity;
import br.com.fiap.manutencoes.repository.entity.ManutencaoEntity;
import br.com.fiap.manutencoes.repository.entity.TipoManutencao;
import br.com.fiap.manutencoes.repository.entity.VeiculoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManutencaoService {
    private ManutencaoRepository repository;

    @Autowired
    public ManutencaoService(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public void registrar(ManutencaoRequest manutencao) {
        String veiculo = manutencao.getIdVeiculo();

        manutencao.getManutencoes().forEach(m -> {
            ManutencaoEntity entity = new ManutencaoEntity();
            entity.setQuilometragemAtual(manutencao.getQuilometragem());
            entity.setDataHora(LocalDateTime.now());
            entity.setVeiculo(new VeiculoEntity(veiculo));
            entity.setComponente(new ComponenteEntity(m.getComponente()));
            entity.setTipoManutencao(new TipoManutencao(m.getTipo()));

            repository.save(entity);
        });
    }
}
