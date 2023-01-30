package br.com.seasolutions.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.seasolutions.model.Cargo;
import br.com.seasolutions.model.Setor;

public class SetorDto {

	private String nome;
	private Long cargos;
	
	public SetorDto(Setor setor) {
		Cargo cargo = new Cargo();
		this.nome = setor.getNome();
		this.cargos = cargo.getId();
	}

	public SetorDto() {
		
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Long getCargos() {
		return cargos;
	}


	public void setCargos(Long cargos) {
		this.cargos = cargos;
	}


	public static List<SetorDto> converter(List<Setor> setor) {
		return setor.stream().map(SetorDto::new).collect(Collectors.toList());
	
	}

}
