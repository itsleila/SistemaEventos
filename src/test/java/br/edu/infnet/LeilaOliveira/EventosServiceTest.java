package br.edu.infnet.LeilaOliveira;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.LeilaOliveira.model.domain.Eventos;
import br.edu.infnet.LeilaOliveira.model.service.EventosService;


@SpringBootTest
public class EventosServiceTest {
	
		EventosService  gerenciarEventos;
		Eventos evento = new Eventos();
				
	@BeforeEach
	void setUp() 
	{
		gerenciarEventos = new EventosService();
		Eventos evento = new Eventos(1, "Evento de moda");
        gerenciarEventos.incluirEvento(evento);
	}
	
	@Test
	void testeIncluir() 
	{
		evento = new Eventos(2,"festa aniversario");
		gerenciarEventos.incluirEvento(evento);
		assertEquals(evento, gerenciarEventos.obterEvento(2));
	}
	
	@Test
	void testeExcluir() 
	{
		gerenciarEventos.excluirEvento(1);
		assertNull(gerenciarEventos.obterEvento(1));
		
	}
	
	@Test
	void testeObterLista() 
	{
		Collection<Eventos> listaEventos = gerenciarEventos.obterLista();
        assertEquals(1, listaEventos.size());
	}
	
	@Test
	void testeObterEvento() 
	{
		Eventos evento = gerenciarEventos.obterEvento(1);
	    assertNotNull(evento);
	    assertEquals("Evento de moda", evento.getNomeEvento());
		   
	}

}


