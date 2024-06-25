package br.com.fiap.manutencoes.repository;

import br.com.fiap.manutencoes.repository.entity.ChaveAcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChaveRepository extends JpaRepository<ChaveAcessoEntity, UUID> {
}
