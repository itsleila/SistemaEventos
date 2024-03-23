package br.edu.infnet.LeilaOliveira.model.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LeilaOliveira.Clients.IAgenciaClient;
import br.edu.infnet.LeilaOliveira.model.domain.Agencia;

@Service
public class AgenciaService {
	@Autowired
	private IAgenciaClient agenciaClient;
	
	public Agencia buscarDadosCNPJ(String cnpj) {
		return agenciaClient.buscarDadosCNPJ(cnpj);
	}
}
