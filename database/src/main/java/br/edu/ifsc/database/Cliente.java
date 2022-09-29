package br.edu.ifsc.database;

public class Cliente {
	private int _idCliente;
	private String _nome;
	private String _telefone;
	private String _cpf;
	
	public Cliente(int idCliente, String nome, String telefone, String cpf) {
		_idCliente = idCliente;
		_nome = nome;
		_telefone = telefone;
		_cpf = cpf;
	}
}
