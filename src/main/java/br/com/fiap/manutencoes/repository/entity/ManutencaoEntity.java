package br.com.fiap.manutencoes.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MANUTENCAO")
public class ManutencaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private VeiculoEntity veiculo;

    @OneToOne( cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_servico", referencedColumnName = "id")
    private ServicoEntity servico;

    @ManyToMany
    @JoinTable(
            name = "manutencao_componentes",
            joinColumns = @JoinColumn(name = "manutencao_id"),
            inverseJoinColumns = @JoinColumn(name = "componente_id"))
    private List<ComponenteEntity> componentes;
}
