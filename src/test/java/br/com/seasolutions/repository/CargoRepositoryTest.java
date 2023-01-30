package br.com.seasolutions.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.seasolutions.model.Cargo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
public class CargoRepositoryTest {
	
	@Autowired
	private CargoRepository cargoRepository;

	@Test
	void deveriaRetornarUmCargoAoProcurarPorSeuNome() {
		String cargoNome = "Cargo 1";
		Optional<Cargo> cargo = cargoRepository.findByNome(cargoNome);
		assertNotNull(cargo);
		assertEquals(cargoNome, cargo.get().getNome());
		
	}

}
