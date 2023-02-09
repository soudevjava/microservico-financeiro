package com.api.financeiro.dtos;

import com.api.financeiro.enums.DespesasTiposEnum;

import java.math.BigDecimal;

public class DespesasDto {

    private BigDecimal valor;
    private DespesasTiposEnum tipo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public DespesasTiposEnum getTipo() {
        return tipo;
    }

    public void setTipo(DespesasTiposEnum tipo) {
        this.tipo = tipo;
    }
}
