package org.projeto.tde.projetoemprestimotde.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.projeto.tde.projetoemprestimotde.DTOs.Funcionario.DetalheFuncionarioDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Funcionario.FuncionarioDTO;
import org.projeto.tde.projetoemprestimotde.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Funcionarios", description = "Endpoints para gerenciamento de funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @Operation(summary = "Listar todos os funcionários", description = "Retorna uma lista de todos os funcionários")
    public ResponseEntity<List<FuncionarioDTO>> getFuncionarios() {
        return ResponseEntity.ok(funcionarioService.getFuncionarios().stream().map(FuncionarioDTO::new).toList());
    }

    @PostMapping
    @Operation(summary = "Criar um novo funcionário", description = "Cria um novo funcionário com os dados fornecidos")
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.createFuncionario(funcionarioDTO)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um funcionário", description = "Atualiza um funcionário existente com os dados fornecidos")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Integer id, @RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.updateFuncionario(id, funcionarioDTO)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter funcionário por ID", description = "Retorna um funcionário específico pelo ID")
    public ResponseEntity<DetalheFuncionarioDTO> getFuncionarioById(@PathVariable Integer id) {
        return ResponseEntity.ok(new DetalheFuncionarioDTO(funcionarioService.getFuncionarioById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um funcionário", description = "Deleta um funcionário específico pelo ID")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Integer id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}