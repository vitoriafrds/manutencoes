package br.com.fiap.manutencoes.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VEICULO")
public class VeiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "COR")
    private String cor;

    @Column(name = "ANO_MODELO")
    private String anoModelo;

    @Column(name = "ANO_FABRICACAO")
    private String anoFabricacao;

    @Column(name = "TIPO_COMBUSTIVEL")
    private String tipoCombustivel;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "CODIGO_CHASSI")
    private String chassi;

    @Column(name = "CODIGO_RENAVAM")
    private String renavam;

    @Column(name = "QUILOMETRAGEM")
    private String quilometragem;

    @OneToMany(mappedBy = "veiculo")
    private List<ManutencaoEntity> manuntencoes;

    public VeiculoEntity(String idVeiculo) {
        this.id = UUID.fromString(idVeiculo);
    }
}
