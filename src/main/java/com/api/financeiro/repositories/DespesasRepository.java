package com.api.financeiro.repositories;

import com.api.financeiro.entities.DespesasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesasRepository extends JpaRepository<DespesasEntity, UUID> {
}
