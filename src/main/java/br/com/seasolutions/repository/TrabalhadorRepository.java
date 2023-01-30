package br.com.seasolutions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seasolutions.model.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {

	Optional<Trabalhador> findByCpf(String nome);
	
}
