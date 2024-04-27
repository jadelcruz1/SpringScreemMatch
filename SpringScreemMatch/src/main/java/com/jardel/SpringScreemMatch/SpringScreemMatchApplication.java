package com.jardel.SpringScreemMatch;

import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringScreemMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringScreemMatchApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		var consumoApi  = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls");
		System.out.println(json);

	}
}
