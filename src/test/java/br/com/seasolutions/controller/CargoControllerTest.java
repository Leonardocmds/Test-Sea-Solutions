package br.com.seasolutions.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.seasolutions.controller.dto.CargoDto;
import br.com.seasolutions.controller.form.CargoForm;
import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.repository.CargoRepository;
import br.com.seasolutions.repository.SetorRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CargoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CargoRepository cargoRepository;
	


	@Test
	void deveriaRetornar400CasoONomeJaExista() throws Exception {
		URI uri = new URI("/cargo");
		String json = "{\"nome\":\"Cargo 3\",\"salario\": 2500,\"setor\": 1}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void deveriaRetornarUmaListaDeCargos() {
		List<Cargo> cargo = cargoRepository.findAll();
		assertNotNull(cargo);
		assertThat(cargo).asList();
	
	}
	
	@Test
	void deveriaRetornar200AoDeletarUmCargo() throws Exception {
		URI uri = new URI("/cargo/1");
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deveriaRetornar400CasoONomeJaExista1() throws Exception {
		URI uri = new URI("/cargo/1");
		String json = "{\"nome\":\"Cargo 6\",\"salario\": 2500,\"setor\": 1}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	

	
		
	
}
