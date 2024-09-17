package org.projeto.tde.projetoemprestimotde.controllers;

import jakarta.validation.Valid;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.CadastroEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.DetalheEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.EquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Equipamento.UpdateEquipamentoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Manutencao.ManutencaoDTO;
import org.projeto.tde.projetoemprestimotde.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> getEquipamentos() {
        return ResponseEntity.ok(equipamentoService.getEquipamentos().stream().map(EquipamentoDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheEquipamentoDTO> getEquipamentoById(@PathVariable Integer id) {
        return ResponseEntity.ok(new DetalheEquipamentoDTO(equipamentoService.getEquipamentoById(id)));
    }

    @PostMapping
    public ResponseEntity<EquipamentoDTO> createEquipamento(@RequestBody @Valid CadastroEquipamentoDTO cadastroEquipamentoDTO) {
        return ResponseEntity.ok(new EquipamentoDTO(equipamentoService.createEquipamento(cadastroEquipamentoDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> updateEquipamento(@PathVariable Integer id, @RequestBody UpdateEquipamentoDTO updateEquipamentoDTO) {
        return ResponseEntity.ok(new EquipamentoDTO(equipamentoService.updateEquipamento(id, updateEquipamentoDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable Integer id) {
        equipamentoService.deleteEquipamento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/manutencao")
    @Operation(summary = "Listar manutenções de um equipamento", description = "Retorna uma lista de manutenções de um equipamento específico pelo ID")
    public ResponseEntity<List<ManutencaoDTO>> getManutencoes(@PathVariable Integer id) {
        return ResponseEntity.ok(equipamentoService.getManutencoes(id).stream().map(ManutencaoDTO::new).toList());
    }

    @PostMapping("/{id}/manutencao")
    @Operation(summary = "Criar uma nova manutenção", description = "Cria uma nova manutenção para um equipamento específico pelo ID")
    public ResponseEntity<ManutencaoDTO> createManutencao(@PathVariable Integer idEquipamento, @RequestBody @Valid ManutencaoDTO manutencaoDTO) {
        return ResponseEntity.ok(new ManutencaoDTO(equipamentoService.createManutencao(idEquipamento, manutencaoDTO)));
    }
}