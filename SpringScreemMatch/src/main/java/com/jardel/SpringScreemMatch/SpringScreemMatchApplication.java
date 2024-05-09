package com.jardel.SpringScreemMatch;

import com.jardel.SpringScreemMatch.model.DadosTemporada;
import com.jardel.SpringScreemMatch.principal.Principal;
import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringScreemMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringScreemMatchApplication.class, args);

		// obter dara atual
		LocalDate hoje = LocalDate.now();

		// obter dara atual com segundos
		LocalDateTime agora = LocalDateTime.now();

		// Criar um formateador de data
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		// Formatando a data e imprimindo
		String dataFormatada = hoje.format(formatter);
		String dataFormatadas = agora.format(formatters);

		// imprimir a data formatada sem segundos  horas
		System.out.println("Data capturada e formatada do jeito que eu quero: " + dataFormatada);

		// imprimir a data formatada com segundos  horas
		System.out.println("Data capturada e formatada do jeito que eu quero: " + dataFormatadas);

		System.out.println("--------------------------------");

		// essa é a data capturada pelo LocalDate.now();
		System.out.println("Data somente caputrada: "+ hoje);
		System.out.println("Data somente caputrada com horas e segundos : " +agora);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}


}
