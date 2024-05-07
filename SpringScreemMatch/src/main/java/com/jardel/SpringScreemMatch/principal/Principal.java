package com.jardel.SpringScreemMatch.principal;

import com.jardel.SpringScreemMatch.model.DadosSerie;
import com.jardel.SpringScreemMatch.model.DadosTemporada;
import com.jardel.SpringScreemMatch.service.ConsumoAPI;
import com.jardel.SpringScreemMatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    private final String ENDERECO = "https://www.omdbapi.com/";
    private final String API_KEY =  "?apikey=910a96b4&t=";

    private ConverteDados conversor  = new ConverteDados();

    //json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=" + i);



    public void exibirMenu(){
        System.out.println("Digite o nome da série ");

        var nomeSerie = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + API_KEY + nomeSerie.replace(" ", "+"));

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i =1; i<=dados.totalTemporadas(); i++){
            ConsumoAPI consumoApi;
            json = consumo.obterDados(ENDERECO + API_KEY + nomeSerie.replace(" ", "+") + "&season=" + i );
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);



        //json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=" + i);

    }

}
