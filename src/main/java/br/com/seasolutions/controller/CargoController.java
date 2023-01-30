package br.com.seasolutions.controller;

import java.net.URI;
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

import br.com.seasolutions.controller.dto.CargoDto;
import br.com.seasolutions.controller.dto.SetorDto;
import br.com.seasolutions.controller.form.CargoForm;
import br.com.seasolutions.controller.form.SetorForm;
import br.com.seasolutions.exception.ErroDeFormularioDto;
import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.repository.CargoRepository;
import br.com.seasolutions.repository.SetorRepository;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping
	public List<CargoDto> listar(){
		List<Cargo> cargo = cargoRepository.findAll();
		return CargoDto.converter(cargo);
	}
	
	@PostMapping
	public ResponseEntity<CargoDto> cadastrar(@RequestBody @Valid CargoForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Cargo> cargoBusca = cargoRepository.findByNome(form.getNome());
		if(cargoBusca.isPresent()) {
			return ResponseEntity.badRequest().build();
					
		}	
		Setor setor = setorRepository.findById(form.getSetor()).get();
		Cargo cargo = new Cargo(form.getNome(), form.getSalario(), setor);
		cargoRepository.save(cargo);
		URI uri = uriBuilder.path("cargo{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(new CargoDto(cargo));
		
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<CargoDto> alterar(@PathVariable Long id,
			@RequestBody @Valid CargoForm form) {
		Cargo cargo = form.atualizar(id,cargoRepository);
		return ResponseEntity.ok(new CargoDto(cargo));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		cargoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
}
