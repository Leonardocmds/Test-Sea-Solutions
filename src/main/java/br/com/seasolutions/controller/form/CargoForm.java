package br.com.seasolutions.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;
import br.com.seasolutions.repository.CargoRepository;

public class CargoForm {

	@NotNull
	private String nome;

	@NotNull
	private BigDecimal salario;

	@NotNull
	private Long setor;

	public CargoForm() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getSetor() {
		return setor;
	}

	public void setSetor(Long setor) {
		this.setor = setor;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Cargo atualizar(Long id, CargoRepository cargoRepository) {
		Cargo cargo = cargoRepository.getById(id);
		cargo.setNome(this.nome);
		return cargo;
	}

}
