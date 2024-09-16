package org.projeto.tde.projetoemprestimotde.repositories;

import org.projeto.tde.projetoemprestimotde.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
