package br.com.fiap.manutencoes.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPONENTE")
public class ComponenteEntity {

    @Id
    private int id;

    @Column(name = "nome")
    private String nome;

    public ComponenteEntity(int id) {
        this.id = id;
    }
}
