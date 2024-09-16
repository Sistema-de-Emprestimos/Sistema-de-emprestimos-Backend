package org.projeto.tde.projetoemprestimotde.DTOs.Equipamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.time.LocalDate;

public record EquipamentoDTO(Integer codigo, String nome, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataCompra, EstadoConservacao estadoConservacao, Boolean disponivel) {

    public EquipamentoDTO(Equipamento equipamento) {
        this(
                equipamento.getCodigo(),
                equipamento.getNome(),
                equipamento.getDataCompra(),
                equipamento.getEstadoConservacao(),
                equipamento.getDisponivel()
            );
    }
}
