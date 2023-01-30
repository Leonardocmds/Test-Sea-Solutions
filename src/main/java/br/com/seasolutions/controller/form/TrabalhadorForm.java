package br.com.seasolutions.controller.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Trabalhador;
import br.com.seasolutions.repository.TrabalhadorRepository;

public class TrabalhadorForm {

	@NotNull
	private String nome;

	@CPF
	private String cpf;
	
	@NotNull
	private Long cargo;
	
	public TrabalhadorForm() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	



	public Long getCargo() {
		return cargo;
	}

	public void setCargo(Long cargo) {
		this.cargo = cargo;
	}

	public Trabalhador atualizar(Long id, TrabalhadorRepository trabalhadorRepository) {
		Trabalhador trabalhador = trabalhadorRepository.getById(id);
		trabalhador.setNome(this.nome);
		trabalhador.setCpf(this.cpf);
		return trabalhador;
	}

}
