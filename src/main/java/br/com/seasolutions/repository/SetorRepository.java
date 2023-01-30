package br.com.seasolutions.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seasolutions.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

	Optional<Setor> findByNome(String nome);

}
