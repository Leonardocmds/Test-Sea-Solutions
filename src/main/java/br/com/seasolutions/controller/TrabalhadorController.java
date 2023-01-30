package br.com.seasolutions.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.seasolutions.controller.dto.TrabalhadorDto;
import br.com.seasolutions.controller.form.TrabalhadorForm;
import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.model.Trabalhador;
import br.com.seasolutions.repository.CargoRepository;
import br.com.seasolutions.repository.TrabalhadorRepository;

@RestController
@RequestMapping("/trabalhador")
public class TrabalhadorController {

	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<TrabalhadorDto> listar(){
		List<Trabalhador> trabalhador = trabalhadorRepository.findAll();
		return TrabalhadorDto.converter(trabalhador);
	}
	
	@PostMapping
	public ResponseEntity<TrabalhadorDto> cadastrar(@RequestBody @Valid TrabalhadorForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Trabalhador> buscaCpf = trabalhadorRepository.findByCpf(form.getCpf());
		if(buscaCpf.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Cargo cargo = cargoRepository.findById(form.getCargo()).get();
		Trabalhador trabalhador = new Trabalhador(form.getNome(),form.getCpf(), cargo);
		trabalhadorRepository.save(trabalhador);
		URI uri = uriBuilder.path("trabalhador{id}").buildAndExpand(trabalhador.getId()).toUri();
		return ResponseEntity.created(uri).body(new TrabalhadorDto(trabalhador));
		
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<TrabalhadorDto> alterar(@PathVariable Long id,
			@RequestBody @Valid TrabalhadorForm form) {
		Trabalhador trabalhador = form.atualizar(id,trabalhadorRepository);
		return ResponseEntity.ok(new TrabalhadorDto(trabalhador));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		trabalhadorRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
}
