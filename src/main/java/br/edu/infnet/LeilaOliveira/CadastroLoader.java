package br.edu.infnet.LeilaOliveira;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LeilaOliveira.model.domain.Agencia;
import br.edu.infnet.LeilaOliveira.model.domain.Eventos;
import br.edu.infnet.LeilaOliveira.model.domain.Localidade;
import br.edu.infnet.LeilaOliveira.model.service.AgenciaMapService;
import br.edu.infnet.LeilaOliveira.model.service.EventosService;
import br.edu.infnet.LeilaOliveira.model.service.LocalidadeService;

@Component
public class CadastroLoader implements ApplicationRunner {

	@Autowired
	private LocalidadeService localidadeService;
	@Autowired
	private AgenciaMapService agenciaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Eventos> eventosAgencia2 = new ArrayList<>();
		EventosService eventoService = new EventosService();

		Eventos evento1 = new Eventos();
		evento1.setId(123456);
		evento1.setNomeEvento("Ano do Dragão!!");
		evento1.setLocal(new Localidade("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP"));
		evento1.setDescricao("Comemoração do ano novo chines");
		evento1.setQtdConvidados(70);
		evento1.setMaxCapacidade(120);
		evento1.setPrecoIngresso(50.0);
		evento1.setData(LocalDate.of(2024, 2, 29));
		evento1.setHorario(LocalTime.of(16, 00, 00));

		eventoService.incluirEvento(evento1);
		eventosAgencia2.add(evento1);
		System.out.println(evento1);
		System.out.println("Receita total do evento: R$" + evento1.calcularReceitaEvento());

		///////////////////////////////////////////////////////////////

		Localidade localidade = localidadeService.obterEndereco("29060-130");
		Eventos evento2 = new Eventos(55555, "AKB48", localidade, "Show de musica", 500, 700, 120.00,
				LocalDate.of(2024, 6, 14), LocalTime.of(18, 00, 00));

		eventoService.incluirEvento(evento2);
		eventosAgencia2.add(evento2);
		System.out.println(eventoService.obterLista());

		////////////////////////////////////////////////////

		Agencia agencia1 = new Agencia("Google", "google@gmail.com", "06947284000104");
		agenciaService.incluirAgencia(agencia1);
		;

		////////////////////////////////////////////////

		Agencia agencia2 = new Agencia("23/11/1998", "ATIVA", "Time For Fun", "R CRISTIANO VIANA", "401",
				"ANDAR 15 ANDAR", "t4f@gmail.com", "(11) 3576-1452", "02860694000162", eventosAgencia2);
		agenciaService.incluirAgencia(agencia2);

	}
}
