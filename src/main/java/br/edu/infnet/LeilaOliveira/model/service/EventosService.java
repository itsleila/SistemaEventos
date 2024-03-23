package br.edu.infnet.LeilaOliveira.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LeilaOliveira.model.domain.Eventos;

@Service
public class EventosService {

	private Map<Integer, Eventos> eventos = new HashMap<Integer, Eventos>();

	public void incluirEvento(Eventos evento) {
		eventos.put(evento.getId(), evento);
	}

	public void excluirEvento(int id) {
		eventos.remove(id);
	}

	public Collection<Eventos> obterLista() {
		return eventos.values();
	}

	public Eventos obterEvento(int id) {
		return eventos.get(id);
	}

}
