package br.com.fiap.manutencoes.repository;

import br.com.fiap.manutencoes.repository.entity.ManutencaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<ManutencaoEntity, Integer> {
}
