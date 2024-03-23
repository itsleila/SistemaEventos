package br.edu.infnet.LeilaOliveira.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;

@FeignClient(url = "https://receitaws.com.br/v1/cnpj", name = "dadosAgenciaClient")
public interface IAgenciaClient {

	@GetMapping(value = "/{cnpj}")
	Agencia buscarDadosCNPJ(@PathVariable String cnpj);

}
