package org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Emprestimo;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.time.LocalDateTime;

public record EmprestimoDTO(
        Integer codigoEmprestimo,

        Integer codigoDoEquipamento,
        String nomeDoEquipamento,
        EstadoConservacao estadoConservacaoEquipamento,

        Integer codigoDoFuncionario,
        String nomeDoFuncionario,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataRetorno,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataSaida,
        String observacoes,
        Boolean concluido
) {
    public EmprestimoDTO(Emprestimo emprestimo) {
        this(
                emprestimo.getCodigo(),
                emprestimo.getEquipamento().getCodigo(),
                emprestimo.getEquipamento().getNome(),
                emprestimo.getEquipamento().getEstadoConservacao(),
                emprestimo.getFuncionario().getCodigo(),
                emprestimo.getFuncionario().getNome(),
                emprestimo.getDataRetorno(),
                emprestimo.getDataSaida(),
                emprestimo.getObservacoes(),
                emprestimo.getConcluido());
    }
}
