package br.com.paulovieira.catalogofilmes.consumo;

import lombok.*;

/**
 * Created by linho on 07/06/2023.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FilmeResponse {
    @EqualsAndHashCode.Include
    private String id;
    private int rank;
    private String title;
    private String fullTitle;
    private int year;
    private String image;
    private String crew;
    private double imDbRating;
    private long imDbRatingCount;
}
