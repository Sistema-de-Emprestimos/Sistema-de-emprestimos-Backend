package org.projeto.tde.projetoemprestimotde.services;

import org.projeto.tde.projetoemprestimotde.DTOs.Funcionario.FuncionarioDTO;
import org.projeto.tde.projetoemprestimotde.entities.Funcionario;
import org.projeto.tde.projetoemprestimotde.repositories.EmprestimoRepository;
import org.projeto.tde.projetoemprestimotde.repositories.EquipamentoRepository;
import org.projeto.tde.projetoemprestimotde.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }
    public Funcionario createFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Funcionario getFuncionarioById(Integer id) {
        return funcionarioRepository.getReferenceById(id);
    }

    public Funcionario updateFuncionario(Integer id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);

        funcionario.update(funcionarioDTO);
        funcionarioRepository.save(funcionario);

        return funcionario;
    }

    public void deleteFuncionario(Integer id) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);
        funcionarioRepository.delete(funcionario);
    }
}