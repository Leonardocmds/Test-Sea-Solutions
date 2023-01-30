package br.com.seasolutions.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.seasolutions.controller.dto.SetorDto;
import br.com.seasolutions.controller.form.SetorForm;
import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.repository.CargoRepository;
import br.com.seasolutions.repository.SetorRepository;

@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping
	public List<SetorDto> listar() {
		List<Setor> setor = setorRepository.findAll();
		return SetorDto.converter(setor);
	}
	

	@PostMapping
	public ResponseEntity<SetorDto> cadastrar(@RequestBody @Valid SetorForm form, UriComponentsBuilder uriBuilder) {
		
		Optional<Setor> setorBusca = setorRepository.findByNome(form.getNome());
		if(setorBusca.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Setor setor = form.converter();
		setorRepository.save(setor);
		URI uri = uriBuilder.path("setor{id}").buildAndExpand(setor.getId()).toUri();
		return ResponseEntity.created(uri).body(new SetorDto(setor));

	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<SetorDto> alterar(@PathVariable Long id, @RequestBody @Valid SetorForm form) {
		Setor setor = form.atualizar(id, setorRepository);
		return ResponseEntity.ok(new SetorDto(setor));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		setorRepository.deleteById(id);
		return ResponseEntity.ok().build();

	}

}
