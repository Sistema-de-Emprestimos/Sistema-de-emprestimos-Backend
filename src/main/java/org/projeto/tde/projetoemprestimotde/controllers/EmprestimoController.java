package org.projeto.tde.projetoemprestimotde.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Emprestimos", description = "Endpoints para gerenciamento de empréstimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    @Operation(summary = "Listar todos os empréstimos", description = "Retorna uma lista de todos os empréstimos")
    public ResponseEntity<List<EmprestimoDTO>> getEmprestimos() {
        return ResponseEntity.ok(emprestimoService.getEmprestimos().stream().map(EmprestimoDTO::new).toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter empréstimo por ID", description = "Retorna um empréstimo específico pelo ID")
    public ResponseEntity<EmprestimoDTO> getEmprestimoById(@PathVariable Integer id) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.getEmprestimoById(id)));
    }

    @PostMapping
    @Operation(summary = "Criar um novo empréstimo", description = "Cria um novo empréstimo com os dados fornecidos")
    public ResponseEntity<EmprestimoDTO> createEmprestimo(@RequestBody CadastroEmprestimoDTO cadastroEmprestimoDTO) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.createEmprestimo(cadastroEmprestimoDTO)));
    }

    @PutMapping("/{id}/retorno")
    @Operation(summary = "Devolver um empréstimo", description = "Marca um empréstimo como devolvido")
    public ResponseEntity<EmprestimoDTO> devolverEmprestimo(@PathVariable Integer id, @RequestBody @Valid RetornoEmprestimoDTO retornoEmprestimoDTO) {
        return ResponseEntity.ok(new EmprestimoDTO(emprestimoService.devolverEmprestimo(id, retornoEmprestimoDTO)));
    }

    @GetMapping("/nao-concluidos")
    @Operation(summary = "Listar empréstimos não concluídos", description = "Retorna uma lista de empréstimos que ainda não foram concluídos")
    public ResponseEntity<List<EmprestimoDTO>> getEmprestimosNaoConcluidos() {
        return ResponseEntity.ok(emprestimoService.getEmprestimosNaoConcluidos().stream().map(EmprestimoDTO::new).toList());
    }
}