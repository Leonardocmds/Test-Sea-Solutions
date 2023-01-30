package br.com.seasolutions.controller.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.repository.SetorRepository;

public class SetorForm {
	
	@NotNull
	private String nome;
	
	private List<Cargo> cargos;
	
	public SetorForm() {
		
	}
	

	public SetorForm(@NotNull String nome, List<Cargo> cargos) {
		
		this.nome = nome;
		this.cargos = cargos;
	}

	public Setor converter() {
		return new Setor(nome, cargos);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Setor atualizar(Long id, SetorRepository setorRepository) {
		Setor setor = setorRepository.getById(id);
		setor.setNome(this.nome);
		return setor;
	}
	
	
	
}
