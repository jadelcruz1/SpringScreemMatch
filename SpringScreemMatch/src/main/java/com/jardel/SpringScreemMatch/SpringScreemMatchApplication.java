package com.jardel.SpringScreemMatch;

import com.jardel.SpringScreemMatch.model.DadosTemporada;
import com.jardel.SpringScreemMatch.principal.Principal;
import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringScreemMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringScreemMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();


	}
}
