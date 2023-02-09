package com.api.financeiro.services;

import com.api.financeiro.entities.DespesasEntity;
import com.api.financeiro.repositories.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;

    @Transactional
    public DespesasEntity criarNovaDespesa(DespesasEntity despesasEntity) {
        return this.despesasRepository.save(despesasEntity);
    }

    public Page<DespesasEntity> findAll(Pageable pageable) {
        return this.despesasRepository.findAll(pageable);
    }

    public Optional<DespesasEntity> findById(UUID id) {
        return this.despesasRepository.findById(id);
    }

    @Transactional
    public Object save(DespesasEntity despesasEntity) {
        return this.despesasRepository.save(despesasEntity);
    }

    @Transactional
    public void remove(DespesasEntity despesasEntity) {
        this.despesasRepository.delete(despesasEntity);
    }
}
