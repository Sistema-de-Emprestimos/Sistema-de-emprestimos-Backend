package org.projeto.tde.projetoemprestimotde.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "manutencoes")
@Getter
@Setter
@EqualsAndHashCode(of = {"codigo"})
@NoArgsConstructor
@AllArgsConstructor
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manutencao_id")
    private Integer codigo;

    private LocalDate data;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
}