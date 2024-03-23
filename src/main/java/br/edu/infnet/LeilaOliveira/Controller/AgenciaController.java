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

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;
import br.edu.infnet.LeilaOliveira.model.service.AgenciaMapService;
import br.edu.infnet.LeilaOliveira.model.service.AgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {
	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private AgenciaMapService agenciaMapService;

	@GetMapping(value = "/{cnpj}")
	public Agencia buscarDadosCNPJ(@PathVariable String cnpj) {
		return agenciaService.buscarDadosCNPJ(cnpj);
	}

	@PostMapping(value = "/incluir")
	public void incluirAgencia(@RequestBody Agencia agencia) {
		agenciaMapService.incluirAgencia(agencia);
	}

	@DeleteMapping(value = "/{cnpj}/excluir")
	public void excluirAgencia(@PathVariable String cnpj) {
		agenciaMapService.excluirAgencia(cnpj);
	}

	@GetMapping(value = "/listar")
	public Collection<Agencia> obterListaAgencia() {
		return agenciaMapService.obterListaAgencia();
	}

	@GetMapping(value = "/{cnpj}/listar")
	public Agencia obterAgencia(@PathVariable String cnpj) {
		return agenciaMapService.obterAgencia(cnpj);
	}

}
