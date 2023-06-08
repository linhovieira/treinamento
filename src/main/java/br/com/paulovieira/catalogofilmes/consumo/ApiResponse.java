package br.com.paulovieira.catalogofilmes.consumo;


import lombok.*;

import java.util.Collection;

/**
 * Created by linho on 08/06/2023.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {
    private String errorMessage;
    private Collection<FilmeResponse> items;
}
