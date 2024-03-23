package br.edu.infnet.LeilaOliveira.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.LeilaOliveira.model.domain.Eventos;
import br.edu.infnet.LeilaOliveira.model.service.EventosService;

@RestController
@RequestMapping("/api/eventos")
public class EventosController {

	@Autowired
	private EventosService eventosService;

	@PostMapping(value = "/incluir")
	public void incluirEvento(@RequestBody Eventos evento) {
		eventosService.incluirEvento(evento);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluirEvento(@PathVariable int id) {
		eventosService.excluirEvento(id);
	}

	@GetMapping(value = "/listar")
	public Collection<Eventos> obterLista() {
		return eventosService.obterLista();
	}

	@GetMapping(value = "/{id}/listar")
	public Eventos obterEvento(@PathVariable int id) {
		return eventosService.obterEvento(id);
	}

}
