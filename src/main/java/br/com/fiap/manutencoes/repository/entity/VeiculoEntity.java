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

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "cor")
    private String cor;

    @Column(name = "ano_modelo")
    private String anoModelo;

    @Column(name = "ano_fabricacao")
    private String anoFabricacao;

    @Column(name = "tipo_combustivel")
    private String tipoCombustivel;

    @Column(name = "placa")
    private String placa;

    @Column(name = "codigo_chassi")
    private String chassi;

    @Column(name = "codigo_renavam")
    private String renavam;

    @Column(name = "quilometragem")
    private String quilometragem;

    @OneToMany(mappedBy = "veiculo")
    private List<ManutencaoEntity> manuntencoes;

    public VeiculoEntity(String idVeiculo) {
        this.id = UUID.fromString(idVeiculo);
    }
}
