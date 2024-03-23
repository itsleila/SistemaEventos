package br.edu.infnet.LeilaOliveira.model.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LeilaOliveira.Clients.ILocalidadeClient;
import br.edu.infnet.LeilaOliveira.model.domain.Localidade;


@Service
public class LocalidadeService {
	
	@Autowired
	private ILocalidadeClient localidadeClient;
	
	public Localidade obterEndereco(String cep) {
		return localidadeClient.obterEndereco(cep);
	}
}

