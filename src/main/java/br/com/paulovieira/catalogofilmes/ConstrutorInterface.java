package br.com.paulovieira.catalogofilmes;

import lombok.SneakyThrows;

/**
 * Created by linho on 08/06/2023.
 */
public class ConstrutorInterface {

    @SneakyThrows
    public static void limparTela() {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

    @SneakyThrows
    public static void pressioneQualquerTeclaParaContinuar() {
        System.out.println("\nPressione qualquer tecla para continuar...");
        var i = System.in.read();
        limparTela();
    }

    public static void exibirBanner() {
        System.out.println("--------------------------------------");
        System.out.println("          Catalogo de Filmes");
        System.out.println("--------------------------------------");
    }

    public static void exibirMenuPrincipal() {
        System.out.println("--- Menu Principal ---");
        System.out.println("[1] - Exibir Lista de Filmes");
        System.out.println("[2] - Pesquisar Filme");
        System.out.println("[0] - Encerrar Aplicação");
        System.out.println("--------------------------------------");
    }
}
