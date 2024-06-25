package br.com.fiap.manutencoes.service;

import br.com.fiap.manutencoes.model.response.ManutencaoResponse;
import br.com.fiap.manutencoes.model.response.VeiculoResponse;
import br.com.fiap.manutencoes.repository.VeiculoRepository;
import br.com.fiap.manutencoes.repository.entity.VeiculoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VeiculoService {
    private VeiculoRepository repository;

    @Autowired
    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Optional<VeiculoResponse> consultarManutencoes(String id) {
        Optional<VeiculoEntity> veiculo = repository.findById(UUID.fromString(id));

        if (veiculo.isPresent()) {
            VeiculoEntity resultado = veiculo.get();

            VeiculoResponse response = new VeiculoResponse();
            response.setId(resultado.getId().toString());
            response.setManutencoes(resultado.getManuntencoes().stream().map(m -> {
                ManutencaoResponse r = new ManutencaoResponse();
                r.setComponente(m.getComponente().getNome());
                r.setData(m.getDataHora());
                r.setQuilometragem(m.getQuilometragemAtual());
                r.setTipo(m.getTipoManutencao().getTipo());

                return r;
            }).collect(Collectors.toList()));


            return Optional.of(response);
        }

        return Optional.empty();
    }

    @Transactional
    public void atualizarQuilometragem(UUID id, long quilometragem) {
        this.repository.atualizarQuilometragem(id, quilometragem);
    }
}
