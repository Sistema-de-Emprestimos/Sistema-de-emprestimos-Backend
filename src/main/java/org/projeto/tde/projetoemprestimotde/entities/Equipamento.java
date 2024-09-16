package org.projeto.tde.projetoemprestimotde.entities;

import jakarta.persistence.*;
import lombok.*;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.CadastroEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.UpdateEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.entities.enums.EstadoConservacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipamentos")
@Getter
@Setter
@EqualsAndHashCode(of = {"codigo"})
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipamento_id")
    private Integer codigo;

    private String nome;
    private String descricao;

    private LocalDate dataCompra;

    private BigDecimal peso;
    private BigDecimal largura;
    private BigDecimal comprimento;

    @Enumerated(EnumType.STRING)
    private EstadoConservacao estadoConservacao;

    private Boolean disponivel = true;

    @OneToMany(mappedBy = "equipamento")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @OneToMany(mappedBy = "equipamento")
    private List<Manutencao> historicoManutencao = new ArrayList<>();

    public Equipamento(CadastroEquipamentoDTO equipamentoDTO) {
        this.setNome(equipamentoDTO.nome());
        this.setDescricao(equipamentoDTO.descricao());
        this.setDataCompra(equipamentoDTO.dataCompra());

        this.setPeso(equipamentoDTO.peso());
        this.setLargura(equipamentoDTO.largura());
        this.setComprimento(equipamentoDTO.comprimento());

        this.setEstadoConservacao(equipamentoDTO.estadoConservacao());
    }

    public Boolean isDisponivel() {
        return this.disponivel;
    }


    public void update(UpdateEquipamentoDTO equipamentoDTO) {
        this.setNome(equipamentoDTO.nome());
        this.setDescricao(equipamentoDTO.descricao());
        this.setDataCompra(equipamentoDTO.dataCompra());

        this.setPeso(equipamentoDTO.peso());
        this.setLargura(equipamentoDTO.largura());
        this.setComprimento(equipamentoDTO.comprimento());

        this.setEstadoConservacao(equipamentoDTO.estadoConservacao());
    }
}
