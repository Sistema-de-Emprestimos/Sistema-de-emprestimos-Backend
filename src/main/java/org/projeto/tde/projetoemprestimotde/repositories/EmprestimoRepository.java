package org.projeto.tde.projetoemprestimotde.repositories;

import org.projeto.tde.projetoemprestimotde.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    List<Emprestimo> findByDataRetornoIsNull();
}
