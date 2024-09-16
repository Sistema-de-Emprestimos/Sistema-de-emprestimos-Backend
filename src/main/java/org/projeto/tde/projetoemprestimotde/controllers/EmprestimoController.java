package org.projeto.tde.projetoemprestimotde.controllers;

import jakarta.validation.Valid;
import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.CadastroEmprestimoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.EmprestimoDTO;
import org.projeto.tde.projetoemprestimotde.DTOs.Emprestimo.RetornoEmprestimoDTO;
import org.projeto.tde.projetoemprestimotde.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> getEmprestimos() {
        return ResponseEntity.ok(emprestimoService.getEmprestimos().stream().map(EmprestimoDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> getEmprestimoById(Integer id) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.getEmprestimoById(id)));
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> createEmprestimo(@RequestBody CadastroEmprestimoDTO cadastroEmprestimoDTO) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.createEmprestimo(cadastroEmprestimoDTO)));
    }

    @PutMapping("/{id}/retorno")
    public ResponseEntity<EmprestimoDTO> devolverEmprestimo(@PathVariable Integer id, @RequestBody @Valid RetornoEmprestimoDTO retornoEmprestimoDTO) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.devolverEmprestimo(id, retornoEmprestimoDTO)));
    }

    @GetMapping("/nao-concluidos")
    public ResponseEntity<List<EmprestimoDTO>> getEmprestimosNaoConcluidos() {
        return ResponseEntity.ok(emprestimoService.getEmprestimosNaoConcluidos().stream().map(EmprestimoDTO::new).toList());
    }
}
