package org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo;

import jakarta.validation.constraints.NotNull;

public record CadastroEmprestimoDTO(
        @NotNull(message = "O código do funcionário é obrigatório")
        Integer codigoFuncionario,
        @NotNull(message = "O código do equipamento é obrigatório")
        Integer codigoEquipamento
) {}
