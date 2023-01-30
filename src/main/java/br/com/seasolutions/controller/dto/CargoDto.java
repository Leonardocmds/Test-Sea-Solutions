package br.com.seasolutions.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;

public class CargoDto {

	private String nome;
	private String setor;
	private BigDecimal salario;
	
	public CargoDto(Cargo cargo) {
		this.nome = cargo.getNome();
		this.salario = cargo.getSalario();
		this.setor = cargo.getSetor().getNome();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public static List<CargoDto> converter(List<Cargo> setor) {
		return setor.stream().map(CargoDto::new).collect(Collectors.toList());
	
	}

}
