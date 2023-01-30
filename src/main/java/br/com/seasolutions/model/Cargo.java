package br.com.seasolutions.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.checkerframework.common.aliasing.qual.Unique;

@Entity
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private BigDecimal salario;
	
	@ManyToOne
	@Unique
	private Setor setor;
	
	@OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
	private List<Trabalhador> trabalhador;
	

	public Cargo(Long id, @NotNull String nome, @NotNull BigDecimal salario, Setor setor, List<Trabalhador> trabalhador) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
		this.trabalhador = trabalhador;
	}
	
	
	

	public Cargo(@NotNull String nome, @NotNull BigDecimal salario, @Unique Setor setor) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
	}




	public Cargo() {
		
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
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Trabalhador> getTrabalhador() {
		return trabalhador;
	}

	public void setTrabalhador(List<Trabalhador> trabalhador) {
		this.trabalhador = trabalhador;
	}
	
	
}
