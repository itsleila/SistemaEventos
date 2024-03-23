package br.edu.infnet.LeilaOliveira;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;
import br.edu.infnet.LeilaOliveira.model.service.AgenciaMapService;


@SpringBootTest
public class AgenciaEventosTest {             
	
	AgenciaMapService agenciaMapService;
	Agencia agencia;

	@BeforeEach
	void setUp() 
	{
		agenciaMapService = new AgenciaMapService();
		agencia = new Agencia();
		agencia.setNome("Jazzy");
		agencia.setEmail("J@gmail.com");
		agencia.setCnpj("5555-55555");
	}
	
	@Test
	void incluirAgencia() {
		
		agenciaMapService.incluirAgencia(agencia);
		assertEquals(agencia, agenciaMapService.obterAgencia(agencia.getCnpj()));
	}
	
	@Test
	void excluirAgencia() 
	{
		agenciaMapService.excluirAgencia(agencia.getCnpj());
		assertNull(agenciaMapService.obterAgencia(agencia.getCnpj()));
		
	}
	
	@Test
	void obterListaAgencia() 
	{
		agenciaMapService.incluirAgencia(agencia);
		  Collection<Agencia> listaAgencia = agenciaMapService.obterListaAgencia();
		  assertEquals(1, listaAgencia.size());
		  assertTrue(listaAgencia.contains(agencia));
		
	}
	@Test
	void testeObterEvento() {
	    agenciaMapService.incluirAgencia(agencia);
	    Agencia agenciaRetornada = agenciaMapService.obterAgencia("5555-55555");
	    assertNotNull(agenciaRetornada);
	    assertEquals(agencia.getNome(), agenciaRetornada.getNome());
	    assertEquals(agencia.getEmail(), agenciaRetornada.getEmail());
	    assertEquals(agencia.getCnpj(), agenciaRetornada.getCnpj());
	}
	@Test
    void validarGetSet() {
    	
    	String nome = "OITNB";
    	String email = "OITNB@gmail.com";
     	String cnpj = "666-777";

   	Agencia agenciaTest = new Agencia (nome,email, cnpj );
       assertEquals(nome, agenciaTest.getNome());
       assertEquals(email, agenciaTest.getEmail());
       assertEquals(cnpj, agenciaTest.getCnpj());;
   }
}

