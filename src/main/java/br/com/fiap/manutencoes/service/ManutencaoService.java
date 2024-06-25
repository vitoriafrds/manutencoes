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
import java.util.UUID;

@Service
public class ManutencaoService {
    private ManutencaoRepository repository;
    private VeiculoService veiculoService;

    @Autowired
    public ManutencaoService(ManutencaoRepository repository, VeiculoService service) {
        this.repository = repository;
        this.veiculoService = service;
    }

    public void registrar(ManutencaoRequest manutencao) {
        String veiculo = manutencao.getIdVeiculo();

        manutencao.getManutencoes().forEach(m -> {
            ManutencaoEntity entity = new ManutencaoEntity();
            entity.setQuilometragemAtual(manutencao.getQuilometragem());
            entity.setDataHora(LocalDateTime.now());
            entity.setVeiculo(new VeiculoEntity(veiculo));
            entity.setTipoManutencao(new TipoManutencao(m.getTipo()));
            entity.setComponente(new ComponenteEntity(m.getComponente()));

            repository.save(entity);
        });

        veiculoService.atualizarQuilometragem(UUID.fromString(manutencao.getIdVeiculo()),
                manutencao.getQuilometragem());

    }
}
