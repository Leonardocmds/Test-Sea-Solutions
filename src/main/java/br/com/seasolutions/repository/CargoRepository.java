package br.com.seasolutions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seasolutions.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Optional<Cargo> findByNome(String nome);
	
}
