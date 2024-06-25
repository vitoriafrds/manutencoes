package br.com.fiap.manutencoes.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MANUTENCAO")
public class ManutencaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "quilometragem_atual")
    private long quilometragemAtual;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private VeiculoEntity veiculo;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tipo_manutencao_id", referencedColumnName = "id")
    private TipoManutencao tipoManutencao;

    //@OneToOne(cascade = CascadeType.DETACH)
    //@JoinColumn(name = "componente_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMPONENTE"))
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "componente_id", referencedColumnName = "id")
    private ComponenteEntity componente;
}
