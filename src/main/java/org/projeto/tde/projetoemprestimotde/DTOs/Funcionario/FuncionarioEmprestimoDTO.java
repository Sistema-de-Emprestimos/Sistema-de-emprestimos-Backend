package org.projeto.tde.projetoemprestimotde.DTOs.Funcionario;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Emprestimo;

import java.time.LocalDateTime;

public record FuncionarioEmprestimoDTO(
        Integer codigoEmprestimo,
        String nomeDoEquipamento,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataRetorno,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataSaida,
        Boolean concluido
) {

    public FuncionarioEmprestimoDTO(Emprestimo emprestimo) {
        this(emprestimo.getCodigo(), emprestimo.getEquipamento().getNome(), emprestimo.getDataRetorno(), emprestimo.getDataSaida(), emprestimo.getConcluido());
    }
}
