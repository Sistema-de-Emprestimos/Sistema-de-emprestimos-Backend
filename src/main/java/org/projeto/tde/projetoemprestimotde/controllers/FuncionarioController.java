package org.projeto.tde.projetoemprestimotde.controllers;

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
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getFuncionarios() {
        return ResponseEntity.ok(funcionarioService.getFuncionarios().stream().map(FuncionarioDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.createFuncionario(funcionarioDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Integer id, @RequestBody FuncionarioDTO funcionarioDTO) {
        return ResponseEntity.ok(new FuncionarioDTO(funcionarioService.updateFuncionario(id, funcionarioDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheFuncionarioDTO> getFuncionarioById(@PathVariable Integer id) {
        return ResponseEntity.ok(new DetalheFuncionarioDTO(funcionarioService.getFuncionarioById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFuncionario(@PathVariable Integer id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
