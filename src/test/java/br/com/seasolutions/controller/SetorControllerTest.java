package br.com.seasolutions.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.seasolutions.model.Setor;
import br.com.seasolutions.model.Trabalhador;
import br.com.seasolutions.repository.SetorRepository;
import br.com.seasolutions.repository.TrabalhadorRepository;

@SpringBootTest
@AutoConfigureMockMvc
class SetorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SetorRepository setorRepository;

	@Test
	void deveriaRetornar400CasoOSetorJaExista() throws Exception {
		URI uri = new URI("/setor");
		String json = "{\"nome\":\"Setor 1\"}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void deveriaRetornarUmaListaDeSetores() {
		List<Setor> setor = setorRepository.findAll();
		assertNotNull(setor);
		assertThat(setor).asList();
	
	}
	
	@Test
	void deveriaRetornar200AoDeletarUmTrabalhador() throws Exception {
		URI uri = new URI("/setor/4");
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deveriaRetornar200AoAlterarUmTrabalhador() throws Exception {
		URI uri = new URI("/setor/3");
		String json = "{\"nome\":\"Setor 6\"}";
		
		mockMvc.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}

}
