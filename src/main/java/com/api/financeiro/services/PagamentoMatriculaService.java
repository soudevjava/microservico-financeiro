package com.api.financeiro.services;

import com.api.financeiro.entities.PagamentoMatriculaEntity;
import com.api.financeiro.repositories.PagamentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoMatriculaService {
    @Autowired
    PagamentoMatriculaRepository pagamentoMatriculaRepository;

    public PagamentoMatriculaEntity novoPagamentoMatricula(PagamentoMatriculaEntity pgto) {
        return this.pagamentoMatriculaRepository.save(pgto);
    }

    public Page<PagamentoMatriculaEntity> findAll(Pageable pageable) {
        return this.pagamentoMatriculaRepository.findAll(pageable);
    }

    public Optional<PagamentoMatriculaEntity> findById(UUID id) {
        return this.pagamentoMatriculaRepository.findById(id);
    }

    public Optional<PagamentoMatriculaEntity> findByMatriculaId(UUID matriculaId) {
        return this.pagamentoMatriculaRepository.findByMatriculaId(matriculaId);
    }
}
