package br.com.paulovieira.catalogofilmes;

import br.com.paulovieira.catalogofilmes.consumo.ConsumoAPI;
import br.com.paulovieira.catalogofilmes.consumo.FilmeResponse;

import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import static br.com.paulovieira.catalogofilmes.ConstrutorInterface.*;

/**
 * Created by linho on 08/06/2023.
 */
public class Gerenciador {
    final static String url = "https://api.mocki.io/v2/549a5d8b";
    final static Collection<FilmeResponse> catalogo = new CopyOnWriteArrayList<>();

    public static void init() throws Exception {
        while (true) {
            exibirBanner();
            exibirMenuPrincipal();
            System.out.print("Informe uma opção: ");
            var opcao = new Scanner(System.in).nextInt();
            switch (opcao) {
                case 0 -> System.exit(-1);
                case 1 -> exibirFilmes();
                case 2 -> pesquisarFilme();
            }
        }
    }

    private static void imprimirFilme(FilmeResponse filme) {
        System.out.printf("Título: %s\n", filme.getTitle());
        System.out.printf("Ano: %d\n", filme.getYear());
        System.out.printf("Rateamento: %.1f\n", filme.getImDbRating());
        System.out.println("---------------------------------------------------------");
    }

    private static void exibirFilmes() throws Exception {
        if (catalogo.isEmpty()) {
            var filmes = new ConsumoAPI(url).consumirFilmes();
            catalogo.addAll(filmes);
        }
        System.out.println("---------------------------------------------------------");
        if (catalogo.size() > 0) {
            catalogo.forEach(Gerenciador::imprimirFilme);
        } else {
            System.out.println("Nenhum filme pode ser encontrado!!!");
        }
        pressioneQualquerTeclaParaContinuar();
    }

    private static void pesquisarFilme() {
        if (catalogo.isEmpty()) {
            System.out.println("O catalogo de filmes encontra-se vazio!!!");
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.print("Digite o nome ou parte do título: ");
            var titulo = new Scanner(System.in).nextLine();
            var filmesFiltrados = catalogo.stream().filter(filme -> filme.getTitle().contains(titulo)).toList();
            if (filmesFiltrados.isEmpty()) {
                System.out.printf("\nNenhum filme pode ser encontrado com titulo informado: [%s]\n", titulo);
            } else {
                System.out.println("---------------------------------------------------------");
                filmesFiltrados.forEach(Gerenciador::imprimirFilme);
            }
            pressioneQualquerTeclaParaContinuar();
        }
    }
}

