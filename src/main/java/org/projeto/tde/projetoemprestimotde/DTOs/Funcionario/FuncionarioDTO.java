package org.projeto.tde.projetoemprestimotde.DTOs.Funcionario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.projeto.tde.projetoemprestimotde.entities.Funcionario;

import java.time.LocalDate;

public record FuncionarioDTO(
        Integer codigo,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Função é obrigatória")
        String funcao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataAdmissao
) {

    public FuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getCodigo(), funcionario.getNome(), funcionario.getFuncao(), funcionario.getDataAdmissao());
    }
}
