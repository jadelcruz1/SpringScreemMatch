package com.jardel.SpringScreemMatch;

import com.jardel.SpringScreemMatch.model.DadosEpisodios;
import com.jardel.SpringScreemMatch.model.DadosSerie;
import com.jardel.SpringScreemMatch.model.DadosTemporada;
import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import com.jardel.SpringScreemMatch.service.ConverteDados;
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
		var consumoApi  = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls");

		System.out.println(json);

		ConverteDados conversor  = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println("Séries " + dados);


		json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=1&episode=2");
		DadosEpisodios dadosEpisodio = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(dadosEpisodio);


		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i =1; i<=dados.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=" + i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}
