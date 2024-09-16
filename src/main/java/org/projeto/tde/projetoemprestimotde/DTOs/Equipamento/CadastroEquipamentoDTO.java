package org.projeto.tde.projetoemprestimotde.DTOs.Equipamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroEquipamentoDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        String descricao,
        @NotNull(message = "A data de compra é obrigatória")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCompra,
        @NotNull(message = "O peso é obrigatório")
        BigDecimal peso,
        @NotNull(message = "A largura é obrigatória")
        BigDecimal largura,
        @NotNull(message = "O comprimento é obrigatório")
        BigDecimal comprimento,
        @NotNull(message = "O estado de conservação é obrigatório")
        EstadoConservacao estadoConservacao
) {}
