package com.api.financeiro.entities;

import com.api.financeiro.enums.DespesasTiposEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TD_DESPESA")
public class DespesasEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private DespesasTiposEnum tipo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public DespesasTiposEnum getTipo() {
        return tipo;
    }

    public void setTipo(DespesasTiposEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DespesasEntity{" + "id=" + id + ", valor=" + valor + ", data=" + data + ", tipo=" + tipo + '}';
    }
}
