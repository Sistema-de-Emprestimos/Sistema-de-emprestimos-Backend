package org.projeto.tde.projetoemprestimotde.DTOs.Manutencao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.projeto.tde.projetoemprestimotde.entities.Manutencao;

import java.time.LocalDate;

public record ManutencaoDTO(Integer codigo, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data, String descricao ) {
    public ManutencaoDTO(Manutencao manutencao) {
        this(manutencao.getCodigo(), manutencao.getData(), manutencao.getDescricao());
    }
}
