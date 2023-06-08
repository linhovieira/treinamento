package br.com.paulovieira.catalogofilmes.consumo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;

/**
 * Created by linho on 08/06/2023.
 */
public class ConsumoAPI {
    private final String url;

    public ConsumoAPI(String url) {
        this.url = url;
    }

    public HttpResponse<String> executarGetFilmes() throws IOException, InterruptedException {
        var endereco = URI.create(this.url);
        var cliente = HttpClient.newHttpClient();
        var requisicao = HttpRequest.newBuilder(endereco).GET().build();
        return cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
    }

    public Collection<FilmeResponse> consumirFilmes() throws IOException, InterruptedException {
        var resposta = this.executarGetFilmes();
        if (200 == resposta.statusCode()) {
            var conteudo = new ObjectMapper().readValue(resposta.body(), ApiResponse.class);
            return conteudo.getItems();
        }
        throw new RuntimeException("Ocorreu um erro na tentativa de consumir os filmes da API!");
    }
}
