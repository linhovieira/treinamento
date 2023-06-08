package br.com.paulovieira.catalogofilmes;


import br.com.paulovieira.catalogofilmes.consumo.ConsumoAPI;

/**
 * Created by linho on 07/06/2023.
 */
public class CatalagoFilmesApplication {
    final static String url = "https://api.mocki.io/v2/549a5d8b";
    public static void main(String[] args) throws Exception {
        var filmes = new ConsumoAPI(url).consumirFilmes();
        filmes.forEach(filme -> {
            System.out.printf("Título: %s\n", filme.getTitle());
            System.out.printf("Ano: %d\n", filme.getYear());
            System.out.printf("Rateamento: %.1f\n", filme.getImDbRating());
            System.out.println("---------------------------------------------------------");
        });
    }
}
