package com.jardel.SpringScreemMatch.principal;

import com.jardel.SpringScreemMatch.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    private final String ENDERECO = "https://www.omdbapi.com/?";
    private final String API_KEY =  "apikey=910a96b4";



    public void exibirMenu(){
        System.out.println("Digite o nome da série ");

        var nomeSerie = leitura.nextLine();


        var json = consumo.obterDados(ENDERECO + API_KEY + nomeSerie.replace(" ", " + "));


        //json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=910a96b4&t=Gilmore+Girls&season=" + i);

    }

}
