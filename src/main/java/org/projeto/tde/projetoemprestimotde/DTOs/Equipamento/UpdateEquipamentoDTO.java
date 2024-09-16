package org.projeto.tde.projetoemprestimotde.DTOs.Equipamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateEquipamentoDTO(
        String nome,
        String descricao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCompra,
        BigDecimal peso,
        BigDecimal largura,
        BigDecimal comprimento,
        EstadoConservacao estadoConservacao
) {
    public UpdateEquipamentoDTO(Equipamento equipamento) {
        this(
                equipamento.getNome(),
                equipamento.getDescricao(),
                equipamento.getDataCompra(),
                equipamento.getPeso(),
                equipamento.getLargura(),
                equipamento.getComprimento(),
                equipamento.getEstadoConservacao()
        );
    }
}