package br.edu.infnet.LeilaOliveira.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;
import br.edu.infnet.LeilaOliveira.model.domain.Eventos;
import br.edu.infnet.LeilaOliveira.model.service.AgenciaMapService;

@RestController
@RequestMapping("/api/agencia/{cnpj}/eventos")
public class AgenciaEventosController {

	@Autowired
	private AgenciaMapService agenciaService;

	@GetMapping(value = "/listar")
	public List<Eventos> obterEventosDaAgencia(@PathVariable String cnpj) {
		Agencia agencia = agenciaService.obterAgencia(cnpj);
		return agencia.getEventos();
	}

	@PostMapping(value = "/incluir")
	public ResponseEntity<Void> adicionarEventoNaAgencia(@PathVariable String cnpj, @RequestBody Eventos evento) {
		Agencia agencia = agenciaService.obterAgencia(cnpj);
		agencia.getEventos().add(evento);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}/excluir")
	public ResponseEntity<Void> excluirEventoDaAgencia(@PathVariable String cnpj, @PathVariable int idEvento) {
		Agencia agencia = agenciaService.obterAgencia(cnpj);
		agencia.getEventos().removeIf(evento -> evento.getId() == idEvento);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}/listar")
	public Eventos obterEventoDaAgenciaPorId(@PathVariable String cnpj, @PathVariable int idEvento) {
		Agencia agencia = agenciaService.obterAgencia(cnpj);
		for (Eventos evento : agencia.getEventos()) {
			if (evento.getId() == idEvento) {
				return evento;
			}
		}
		return null;
	}
}
