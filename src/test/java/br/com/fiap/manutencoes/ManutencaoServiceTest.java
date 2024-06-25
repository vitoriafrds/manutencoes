package br.com.fiap.manutencoes;

import br.com.fiap.manutencoes.model.Manutencao;
import br.com.fiap.manutencoes.model.request.ManutencaoRequest;
import br.com.fiap.manutencoes.repository.ManutencaoRepository;
import br.com.fiap.manutencoes.repository.entity.ComponenteEntity;
import br.com.fiap.manutencoes.repository.entity.ManutencaoEntity;
import br.com.fiap.manutencoes.repository.entity.TipoManutencao;
import br.com.fiap.manutencoes.repository.entity.VeiculoEntity;
import br.com.fiap.manutencoes.service.ManutencaoService;
import br.com.fiap.manutencoes.service.VeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ManutencaoServiceTest {
    private static final String ID_VEICULO = UUID.randomUUID().toString();

    @Mock
    private ManutencaoRepository repositoryMock;

    @Mock
    private VeiculoService veiculoService;

    private ManutencaoService manutencaoService;


    @BeforeEach
    public void setUp() {
        this.manutencaoService = new ManutencaoService(this.repositoryMock, this.veiculoService);
    }

    @Test
    void test_DeveCadastrar_Manutencao_Corretamente() {
        var manutencao = criarManutencaoEntity();
        when(repositoryMock.save(any(ManutencaoEntity.class))).thenReturn(manutencao);

        manutencaoService.registrar(criarManutencaoRequest());

        verify(veiculoService, times(1))
                .atualizarQuilometragem(UUID.fromString(ID_VEICULO), 9000);
    }

    private static ManutencaoRequest criarManutencaoRequest() {
        ManutencaoRequest request = new ManutencaoRequest();
        request.setIdVeiculo(ID_VEICULO);
        request.setQuilometragem(9000);

        Manutencao manutencao = new Manutencao();
        manutencao.setComponente(2);
        manutencao.setTipo(1);

        request.setManutencoes(List.of(manutencao));

        return request;
    }

    private static ManutencaoEntity criarManutencaoEntity() {
        ManutencaoEntity entity = new ManutencaoEntity();
        entity.setTipoManutencao(new TipoManutencao(1));
        entity.setVeiculo(new VeiculoEntity(ID_VEICULO));
        entity.setComponente(new ComponenteEntity(1));
        entity.setDataHora(LocalDateTime.now());
        entity.setQuilometragemAtual(8000);

        return entity;

    }
}
