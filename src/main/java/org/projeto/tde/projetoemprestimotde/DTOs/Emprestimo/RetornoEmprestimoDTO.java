package org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo;

import jakarta.validation.constraints.NotNull;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

public record RetornoEmprestimoDTO (
        @NotNull(message = "Observação é obrigatória")
        String observacoes,
        @NotNull(message = "Estado de conservação é obrigatório")
        EstadoConservacao estadoConservacao
) {}
