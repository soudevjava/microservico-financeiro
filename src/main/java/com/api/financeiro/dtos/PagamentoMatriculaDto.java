package com.api.financeiro.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class PagamentoMatriculaDto {
    private UUID matriculaId;
    private UUID cursoId;
    private BigDecimal valor;

    public UUID getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(UUID matriculaId) {
        this.matriculaId = matriculaId;
    }

    public UUID getCursoId() {
        return cursoId;
    }

    public void setCursoId(UUID cursoId) {
        this.cursoId = cursoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
