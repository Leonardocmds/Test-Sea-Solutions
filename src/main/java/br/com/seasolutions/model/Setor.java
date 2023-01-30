package br.com.seasolutions.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Setor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Column(unique = true)
	private String nome;
		
	@OneToMany(mappedBy = "setor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Cargo>  cargos = new ArrayList<>();
	

	public Setor(Long id,  String nome, List<Cargo> cargos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargos = cargos;
	}
	
	public Setor(String nome, List<Cargo> cargos) {
		this.nome = nome;
		this.cargos = cargos;
	
		
	}

	public Setor() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setCargo(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	

	

}
