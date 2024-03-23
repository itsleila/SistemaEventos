package br.edu.infnet.LeilaOliveira.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.LeilaOliveira.model.domain.Localidade;
import br.edu.infnet.LeilaOliveira.model.service.LocalidadeService;


@RestController
@RequestMapping("/api/localidade")
public class LocalidadeController {
	@Autowired
	private LocalidadeService localidadeService;
	
	@GetMapping(value = "/{cep}")
	public Localidade obterEndereco(@PathVariable String cep) {
		return localidadeService.obterEndereco(cep);
	}

}
