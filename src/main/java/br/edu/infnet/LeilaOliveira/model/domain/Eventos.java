package br.edu.infnet.LeilaOliveira.model.domain;


import java.time.LocalTime;
import java.time.LocalDate;

public class Eventos {

	private int id;
	private String nomeEvento;
	private String descricao;
	private Localidade local;
	private int qtdConvidados;
	private int maxCapacidade;
	private double precoIngresso;
	private LocalDate data;
	private LocalTime horario;

    public Eventos() {}
	
	public Eventos(int id, String nomeEvento) 
	{
		this.id = id;
		this.nomeEvento = nomeEvento;

	}
	
	

	public Eventos(int id,String nomeEvento, Localidade local, String descricao, int qtdConvidados, int maxCapacidade,
			double precoIngresso, LocalDate data, LocalTime horario) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.local = local;
		this.descricao = descricao;
		this.qtdConvidados = qtdConvidados;
		this.maxCapacidade = maxCapacidade;
		this.precoIngresso = precoIngresso;
		this.data = data;
		this.horario = horario;
	}

	public void capacidadeMax() {
		if (qtdConvidados > maxCapacidade && maxCapacidade > 0) {
			throw new IllegalStateException("Capacidade máxima do evento excedida");
		}
	}

	public void validarPrecoIngresso() {
		if (precoIngresso <= 0.0) {
			throw new IllegalStateException("Preço do ingresso inválido");
		}
	}

	public double calcularReceitaEvento() throws IllegalStateException {
		capacidadeMax();
		validarPrecoIngresso();
		return qtdConvidados * precoIngresso;
	}

	public boolean validarDataHorarioEvento() {
	    LocalDate hoje = LocalDate.now();
	    LocalTime agora = LocalTime.now();

	    if (data == null || data.isBefore(hoje)) {
	        return false;
	    }
	    if (horario == null || horario.isBefore(agora)) { 
	        return false;
	    }
	    return true;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Localidade getLocal() {
		return local;
	}

	public void setLocal(Localidade local) {
		this.local = local;
	}

	public int getQtdConvidados() {
		return qtdConvidados;
	}

	public void setQtdConvidados(int qtdConvidados) {
		this.qtdConvidados = qtdConvidados;
	}

	public int getMaxCapacidade() {
		return maxCapacidade;
	}

	public void setMaxCapacidade(int maxCapacidade) {
		this.maxCapacidade = maxCapacidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(double precoIngresso) {
		this.precoIngresso = precoIngresso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Nome do Evento: " + nomeEvento + "\nDescrição: " + descricao + "\nPreço do ingresso: " + precoIngresso
				+ "\nLocal: " + local + "\nData: " + data + "\nHorário: " + horario;
	}

}

