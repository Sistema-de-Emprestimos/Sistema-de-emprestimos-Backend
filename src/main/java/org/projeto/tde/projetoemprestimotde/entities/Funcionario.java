package org.projeto.tde.projetoemprestimotde.entities;

import jakarta.persistence.*;
import lombok.*;
import org.projeto.tde.projetoemprestimotde.DTOs.Funcionario.FuncionarioDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"codigo"})
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Integer codigo;

    private String nome;

    private String funcao;

    private LocalDate dataAdmissao;

    @OneToMany(mappedBy = "funcionario")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Funcionario(FuncionarioDTO funcionarioDTO) {
        this.setNome(funcionarioDTO.nome());
        this.setFuncao(funcionarioDTO.funcao());
        this.setDataAdmissao(LocalDate.now());
    }
}