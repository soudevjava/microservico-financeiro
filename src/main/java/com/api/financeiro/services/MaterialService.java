package com.api.financeiro.services;

import com.api.financeiro.entities.DespesasEntity;
import com.api.financeiro.entities.MaterialEntity;
import com.api.financeiro.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

@Service
public class MaterialService{


    @Autowired
    private MaterialRepository materialRepository;

    @Transactional
    public MaterialEntity cadastrarNovoMaterial(MaterialEntity materialEntity) {
        return this.materialRepository.save(materialEntity);
    }
    public Page<MaterialEntity> findAll(Pageable pageable) {
        return this.materialRepository.findAll(pageable);
    }


    public Optional<MaterialEntity> finById(UUID id) {
        return materialRepository.findById(id);
    }

    public void remove(MaterialEntity materialEntity) {
        this.materialRepository.delete(materialEntity);
    }

    public Object save(MaterialEntity materialEntity) {
        return materialRepository.save(materialEntity);
    }
}
