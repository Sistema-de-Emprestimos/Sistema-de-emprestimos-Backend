package org.projeto.tde.projetoemprestimotde.services;

import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.CadastroEmprestimoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.RetornoEmprestimoDTO;
import org.projeto.tde.projetoemprestimotde.entities.Emprestimo;
import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.projeto.tde.projetoemprestimotde.entities.Funcionario;
import org.projeto.tde.projetoemprestimotde.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> getEmprestimos() {
        return emprestimoRepository.findAll(Sort.by(
                Sort.Order.asc("concluido"),
                Sort.Order.desc("dataSaida")
        ));
    }

    public Emprestimo getEmprestimoById(Integer id) {
        return emprestimoRepository.getReferenceById(id);
    }

    public Emprestimo createEmprestimo(CadastroEmprestimoDTO cadastroEmprestimoDTO) {
        Equipamento equipamento = equipamentoService.getEquipamentoById(cadastroEmprestimoDTO.codigoEquipamento());
        Funcionario funcionario = funcionarioService.getFuncionarioById(cadastroEmprestimoDTO.codigoFuncionario());

        if (!equipamento.isDisponivel()) {
            throw new RuntimeException("Equipamento já emprestado");
        }

        Emprestimo emprestimo = new Emprestimo(funcionario, equipamento);
        equipamento.retirarEquipamento();
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

    public Emprestimo devolverEmprestimo(Integer id, RetornoEmprestimoDTO retornoEmprestimoDTO) {
        Emprestimo emprestimo = emprestimoRepository.getReferenceById(id);
        emprestimo.devolverEmprestimo(retornoEmprestimoDTO);
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

    public List<Emprestimo> getEmprestimosNaoConcluidos() {
        return emprestimoRepository.findByDataRetornoIsNull();
    }
}
