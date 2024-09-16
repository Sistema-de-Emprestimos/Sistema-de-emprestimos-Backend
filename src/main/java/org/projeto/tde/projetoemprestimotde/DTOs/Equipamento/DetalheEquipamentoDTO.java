package org.projeto.tde.projetoemprestimotde.DTOs.Equipamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DetalheEquipamentoDTO(
        Integer codigo,
        String nome,
        String descricao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCompra,
        BigDecimal peso,
        BigDecimal largura,
        BigDecimal comprimento,
        EstadoConservacao estadoConservacao,
        Boolean disponivel
) {

    public DetalheEquipamentoDTO(Equipamento equipamento) {
        this(
                equipamento.getCodigo(),
                equipamento.getNome(),
                equipamento.getDescricao(),
                equipamento.getDataCompra(),
                equipamento.getPeso(),
                equipamento.getLargura(),
                equipamento.getComprimento(),
                equipamento.getEstadoConservacao(),
                equipamento.getDisponivel()
            );
    }
}