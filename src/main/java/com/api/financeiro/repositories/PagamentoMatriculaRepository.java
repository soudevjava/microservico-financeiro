package com.api.financeiro.repositories;

import com.api.financeiro.entities.PagamentoMatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoMatriculaRepository extends JpaRepository<PagamentoMatriculaEntity, UUID> {
    Optional<PagamentoMatriculaEntity> findByMatriculaId(UUID matriculaId);
}
