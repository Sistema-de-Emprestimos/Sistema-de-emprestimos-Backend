package org.projeto.tde.projetoemprestimotde.services;

import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.CadastroEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.UpdateEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.projeto.tde.projetoemprestimotde.entities.Manutencao;
import org.projeto.tde.projetoemprestimotde.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;


    public List<Equipamento> getEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento getEquipamentoById(Integer id) {
        return equipamentoRepository.getReferenceById(id);
    }

    public Equipamento createEquipamento(CadastroEquipamentoDTO cadastroEquipamentoDTO) {
        Equipamento equipamento = new Equipamento(cadastroEquipamentoDTO);
        equipamentoRepository.save(equipamento);
        return equipamento;
    }

    public Equipamento updateEquipamento(Integer id, UpdateEquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoRepository.getReferenceById(id);
        equipamento.update(equipamentoDTO);
        equipamentoRepository.save(equipamento);
        return equipamento;
    }

    public void deleteEquipamento(Integer id) {
        Equipamento equipamento = equipamentoRepository.getReferenceById(id);
        if (!equipamento.isDisponivel()) {
            throw new RuntimeException("Equipamento não pode ser deletado, pois está emprestado");
        }
        equipamentoRepository.delete(equipamento);
    }

    public List<Manutencao> getManutencoes(Integer id) {
        Equipamento equipamento = equipamentoRepository.getReferenceById(id);
        return equipamento.getHistoricoManutencao();
    }
}