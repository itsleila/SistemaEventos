package br.edu.infnet.LeilaOliveira.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;
import br.edu.infnet.LeilaOliveira.model.domain.Eventos;

@Service
public class AgenciaMapService { 
	    
	    private Map<String, Agencia> agencias = new HashMap<String, Agencia>();
	    
	    
	    public void incluirAgencia(Agencia agencia) {
	        agencias.put(agencia.getCnpj(), agencia);
	    }
	
	    public void excluirAgencia(String cnpj) {
	        agencias.remove(cnpj);
	    }
	    
	    public Collection<Agencia> obterListaAgencia() {
	        return agencias.values();
	    }
	
	    public Agencia obterAgencia(String cnpj) {
	        return agencias.get(cnpj);
	    }
	    
	    public void adicionarEvento(String cnpj, Eventos evento) {
	        Agencia agencia = agencias.get(cnpj);
	        agencia.getEventos().add(evento);
	    }
	   
	    
}
