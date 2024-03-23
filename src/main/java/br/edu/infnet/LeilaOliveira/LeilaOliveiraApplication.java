package br.edu.infnet.LeilaOliveira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LeilaOliveiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeilaOliveiraApplication.class, args);
	}

}
