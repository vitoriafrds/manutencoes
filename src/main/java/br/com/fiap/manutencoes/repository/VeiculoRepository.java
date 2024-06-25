package br.com.fiap.manutencoes.repository;

import br.com.fiap.manutencoes.repository.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, UUID> {

    @Modifying
    @Query(value = "update veiculo set quilometragem=?2 where id=?1", nativeQuery = true)
    void atualizarQuilometragem(UUID id, long quilometragem);
}
