package org.projeto.tde.projetoemprestimotde.repositories;

import org.projeto.tde.projetoemprestimotde.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
}
