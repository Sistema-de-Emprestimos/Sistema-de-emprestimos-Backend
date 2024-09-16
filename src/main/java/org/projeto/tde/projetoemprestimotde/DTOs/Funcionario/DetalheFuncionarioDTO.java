package org.projeto.tde.projetoemprestimotde.DTOs.Funcionario;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Funcionario;

import java.time.LocalDate;
import java.util.List;

public record DetalheFuncionarioDTO(
        String nome,
        String funcao,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataAdmissao,
        List<FuncionarioEmprestimoDTO> emprestimos
) {

    public DetalheFuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getNome(), funcionario.getFuncao(), funcionario.getDataAdmissao(), funcionario.getEmprestimos().stream().map(FuncionarioEmprestimoDTO::new).toList());
    }
}
