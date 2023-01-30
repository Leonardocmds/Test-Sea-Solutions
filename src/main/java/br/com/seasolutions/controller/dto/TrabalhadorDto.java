package br.com.seasolutions.controller.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.seasolutions.model.Setor;
import br.com.seasolutions.model.Trabalhador;

public class TrabalhadorDto {

	private String nome;
	private String cpf;
	private String cargo;
	private String setor;
	
	public TrabalhadorDto(Trabalhador trabalhador) {
		this.nome = trabalhador.getNome();
		this.cpf = trabalhador.getCpf();
		this.cargo = trabalhador.getCargo().getNome();
		this.setor = trabalhador.getCargo().getSetor().getNome();
	
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

	
	

	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public static List<TrabalhadorDto> converter(List<Trabalhador> trabalhador) {
		return trabalhador.stream().map(TrabalhadorDto::new).collect(Collectors.toList());
	
	}

}
