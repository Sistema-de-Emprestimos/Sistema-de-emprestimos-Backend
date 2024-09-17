package org.projeto.tde.projetoemprestimotde.DTOs.Manutencao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.projeto.tde.projetoemprestimotde.entities.Manutencao;

import java.time.LocalDate;

public record ManutencaoDTO(
        Integer codigo,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "A data é obrigatória")
        LocalDate data,
        @NotBlank(message = "A descrição é obrigatória")
        String descricao
) {
    public ManutencaoDTO(Manutencao manutencao) {
        this(manutencao.getCodigo(), manutencao.getData(), manutencao.getDescricao());
    }
}
