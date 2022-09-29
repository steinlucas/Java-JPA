package br.edu.ifsc.database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	private String nome;
	private String telefone;
	private String cpf;
	
	public Cliente(int idCliente, String nome, String telefone, String cpf) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
