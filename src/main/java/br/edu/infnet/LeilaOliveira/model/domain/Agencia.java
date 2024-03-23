package br.edu.infnet.LeilaOliveira.model.domain;

import java.util.List;

public class Agencia {
	
    private String abertura;
    private String situacao;
    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String email;
    private String telefone;
    private String cnpj;
    private List<Eventos> eventos;
   
	
	public Agencia() {
		
	} 

	public Agencia(String nome, String email, String cnpj) {
		super();
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
	}
	
	

	public Agencia(String abertura, String situacao, String nome, String logradouro, String numero, String complemento,
			String email, String telefone, String cnpj, List<Eventos> eventos) {
		super();
		this.abertura = abertura;
		this.situacao = situacao;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.eventos = eventos;
	}

	public String getAbertura() {
		return abertura;
	}



	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}



	public String getSituacao() {
		return situacao;
	}



	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Eventos> getEventos() {
		return eventos; //testar
	}

	public void setEventos( List<Eventos> eventos) {
		this.eventos = eventos; //testar
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nCnpj: " + cnpj  + "\nEmail: " + email
				+ "\nLocalidade: " + logradouro +" - "+numero+" - " + complemento + "\nSituação Cadastral:" + situacao;
	} 
	
}










