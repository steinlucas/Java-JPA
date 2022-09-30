package br.edu.ifsc.database.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrcamento;
	private int valor;
	private String data;
		
	public Orcamento(int idOrcamento, int valor, String data) {
		this.setIdOrcamento(idOrcamento);
		this.setValor(valor);
		this.setData(data);
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
