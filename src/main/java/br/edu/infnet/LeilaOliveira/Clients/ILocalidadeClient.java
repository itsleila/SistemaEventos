package br.edu.infnet.LeilaOliveira.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.LeilaOliveira.model.domain.Localidade;

@FeignClient(url = "https://viacep.com.br/ws", name = "localidadeClient")
public interface ILocalidadeClient {

	@GetMapping(value = "/{cep}/json/")
	Localidade obterEndereco(@PathVariable String cep);
}
