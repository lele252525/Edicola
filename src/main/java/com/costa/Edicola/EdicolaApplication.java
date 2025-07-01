package com.costa.Edicola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdicolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdicolaApplication.class, args);
		
		System.out.println();
		System.out.println("Selezionare: tipologia (1. Giornaliero - 2. Settimanale - 3. Mensile), numero e scadenza.");
	}

}
