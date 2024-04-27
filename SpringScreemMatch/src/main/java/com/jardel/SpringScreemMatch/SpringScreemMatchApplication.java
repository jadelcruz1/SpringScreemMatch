package com.jardel.SpringScreemMatch;

import com.jardel.SpringScreemMatch.model.DadosEpisodios;
import com.jardel.SpringScreemMatch.model.DadosSerie;
import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import com.jardel.SpringScreemMatch.service.ConverteDados;
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
		//var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls");
		var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=1&episode=2");
		System.out.println(json);

		ConverteDados conversor  = new ConverteDados();
		DadosSerie dadosSeries = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSeries);

		DadosEpisodios dadosEpisodio = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(dadosEpisodio);


	}
}
