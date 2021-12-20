package br.edu.aranoua.ramonsantos.princesas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Princesas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=false)
	private String nome;
	@Column(nullable=false, unique=false)
	private String reino;
	@Column(nullable=false, unique=false)
	private int idade;
	
	public Princesas() {
		
	}

	public Princesas(Long id, String nome, String reino, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.reino = reino;
		this.idade = idade;
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

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "princesas [id=" + id + ", nome=" + nome + ", reino=" + reino + ", idade=" + idade + "]";
	}
	
	

}
