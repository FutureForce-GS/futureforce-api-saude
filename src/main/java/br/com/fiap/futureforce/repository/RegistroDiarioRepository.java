package br.com.fiap.futureforce.repository;

import br.com.fiap.futureforce.model.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
}
