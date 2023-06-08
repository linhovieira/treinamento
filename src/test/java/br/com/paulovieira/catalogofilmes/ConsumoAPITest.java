package br.com.paulovieira.catalogofilmes;

import br.com.paulovieira.catalogofilmes.consumo.ApiResponse;
import br.com.paulovieira.catalogofilmes.consumo.ConsumoAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by linho on 08/06/2023.
 */
public class ConsumoAPITest {
    final static String url = "https://api.mocki.io/v2/549a5d8b";

    @Test
    @DisplayName(value = "Teste de requisição para API de filmes")
    void deveriaRetornar200ComFilmes_quandoRequisitarApi() {
        assertDoesNotThrow(() -> {
            var resposta = new ConsumoAPI(url).executarGetFilmes();
            assertNotNull(resposta);
            assertEquals(200, resposta.statusCode());
            assertNotNull(resposta.body());
        });
    }

    @Test
    @DisplayName(value = "Teste de requisição para API de filmes com url inválida")
    void deveriaRetornar403_quandoRequisitarApiComUrlInvalida() {
        assertDoesNotThrow(() -> {
            var resposta = new ConsumoAPI(url.replace("v2/549a5d8b", "v3/549a5d8b")).executarGetFilmes();
            assertNotNull(resposta);
            assertEquals(403, resposta.statusCode());
        });
    }

    @Test
    @DisplayName(value = "Teste de conversão do corpo JSON para ApiResponse")
    void deveriaConverterCorpoJsonParaApiResponse_quando() throws Exception {
        var resposta = new ConsumoAPI(url).executarGetFilmes();
        if (200 == resposta.statusCode()) {
            assertDoesNotThrow(() -> {
                var conteudo = new ObjectMapper().readValue(resposta.body(), ApiResponse.class);
                assertNotNull(conteudo);
                assertNotNull(conteudo.getItems());
                assertTrue(conteudo.getItems().size() > 0);
            });
        }
    }
}
