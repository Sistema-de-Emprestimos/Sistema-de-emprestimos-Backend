package org.projeto.tde.projetoemprestimotde.entities;

import jakarta.persistence.*;
import lombok.*;
import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.RetornoEmprestimoDTO;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = {"codigo"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private Integer codigo;

    private LocalDateTime dataSaida;

    private LocalDateTime dataRetorno;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    private String observacoes;

    private Boolean concluido = false;

    public Emprestimo(Funcionario funcionario, Equipamento equipamento) {
        this.setFuncionario(funcionario);
        this.setEquipamento(equipamento);
        this.setDataSaida(LocalDateTime.now());
    }

    public void devolverEmprestimo(RetornoEmprestimoDTO retornoEmprestimoDTO) {
        this.setObservacoes(retornoEmprestimoDTO.observacoes());
        this.setConcluido(true);
        this.setDataRetorno(LocalDateTime.now());
        this.getEquipamento().setEstadoConservacao(retornoEmprestimoDTO.estadoConservacao());
    }
}
