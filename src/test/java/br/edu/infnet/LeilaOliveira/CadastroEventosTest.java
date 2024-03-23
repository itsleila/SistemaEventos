package br.edu.infnet.LeilaOliveira;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.LeilaOliveira.model.domain.Eventos;


@SpringBootTest
public class CadastroEventosTest {

	Eventos eventoTeste = new Eventos();                   
	
	//@BeforeEach
	//void setUp() {}
	
	 @Test
	    void calcularReceitaEvento() {
		  eventoTeste.setQtdConvidados(50);
		  eventoTeste.setPrecoIngresso(25.0);
	      assertEquals(1250.0, eventoTeste.calcularReceitaEvento());
	     }
	 
	 //////////////////
	 
	 @Test
	    void capacidadeMax() {
	        eventoTeste.setMaxCapacidade(100);
	        eventoTeste.setQtdConvidados(110);   
	        assertThrows(IllegalStateException.class, eventoTeste::capacidadeMax); 
	    }
	 /////////////////////
	 
	 @Test
	    void precoIngressoZero() {
	        eventoTeste.setPrecoIngresso(0.0);
	        assertThrows(IllegalStateException.class, eventoTeste::validarPrecoIngresso);
	    }
	 /////////////
	 @Test
	    void precoIngressoNegativo() {
	        eventoTeste.setPrecoIngresso(-10.0);
	        assertThrows(IllegalStateException.class, eventoTeste::validarPrecoIngresso);
	    }
	    
	    ///////////
	    @Test
	    void dataHorarioValidos() {
	        LocalDate dataFutura = LocalDate.now().plusDays(1);
	        LocalTime horarioFuturo = LocalTime.now().plusHours(1);
	        eventoTeste.setData(dataFutura);
	        eventoTeste.setHorario(horarioFuturo);
	        assertTrue(eventoTeste.validarDataHorarioEvento());
	    }
	    
	    //////////////// 
	    @Test
	    void dataFuturaHorarioPassado() {
	        LocalDate dataFutura = LocalDate.now().plusDays(1);
	        LocalTime horarioPassado = LocalTime.now().minusHours(1);
	        eventoTeste.setData(dataFutura);
	        eventoTeste.setHorario(horarioPassado);
	        
	        assertFalse(eventoTeste.validarDataHorarioEvento());
	    }
	    
	    //////////
	    @Test
	    void dataNula() {
	        eventoTeste.setHorario(LocalTime.now());

	        
	        assertFalse(eventoTeste.validarDataHorarioEvento());
	    }
	    /////////
	    @Test
	    void horarioNulo() {
	    	eventoTeste.setData(LocalDate.now().plusDays(1));

	    	assertFalse(eventoTeste.validarDataHorarioEvento());
	    }
	    //////////
	    @Test
	    void dataPassada() {
	    	eventoTeste.setData(LocalDate.now().minusDays(1));
	        eventoTeste.setHorario(LocalTime.now());

	        assertFalse(eventoTeste.validarDataHorarioEvento());
	    }
	    //////////
	  
	    @Test
	    void horarioPassado() {
	        LocalDate dataFutura = LocalDate.now().plusDays(1);
	        LocalTime horarioPassado = LocalTime.now().minusHours(1);
	        eventoTeste.setData(dataFutura);
	        eventoTeste.setHorario(horarioPassado);

	        assertFalse(eventoTeste.validarDataHorarioEvento());
	    }
	    
	    
	    
	    
	    ////////
//	    @Test
//	    void validarGets() {
//	    	int id = 111222333;
//	        String nomeEvento = "Bienal do Livro.";
//	        Localidade local = "Distrito Anhembi";
//	        String descricao = "Evento literário e cultural, para promover o lançamento de obras e debates sobre temas pertinentes.";
//	        int qtdConvidados = 500;
//	        int maxCapacidade = 1000;
//	        double precoIngresso = 25.0;
//	        LocalDate data = LocalDate.of(2024, 3, 15);
//	        LocalTime horario = LocalTime.of(11, 0);
//
//	        Eventos evento = new Eventos(id,nomeEvento, local, descricao, qtdConvidados, maxCapacidade, precoIngresso, data, horario);
//
//	        assertEquals(id, evento.getId());
//	        assertEquals(nomeEvento, evento.getNomeEvento());
//	        assertEquals(local, evento.getLocal());
//	        assertEquals(descricao, evento.getDescricao());
//	        assertEquals(qtdConvidados, evento.getQtdConvidados());
//	        assertEquals(maxCapacidade, evento.getMaxCapacidade());
//	        assertEquals(precoIngresso, evento.getPrecoIngresso());
//	        assertEquals(data, evento.getData());
//	        assertEquals(horario, evento.getHorario());
//	    }
	 
}

