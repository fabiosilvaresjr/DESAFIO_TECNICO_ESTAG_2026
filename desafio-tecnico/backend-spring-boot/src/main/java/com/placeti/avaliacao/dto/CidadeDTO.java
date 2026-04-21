package com.placeti.avaliacao.dto;

import com.placeti.avaliacao.model.Cidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO que guarda os dados de uma cidade
 */
public record CidadeDTO(

        //---------------------------------------
        // Atributos do DTO
        //---------------------------------------
        Long id,

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Size(min = 2, max = 2)
        String uf,

        @NotNull
        Boolean capital
) {

    public static CidadeDTO fromEntity(Cidade cidade) {
        return new CidadeDTO(cidade.getId(), cidade.getNome(), cidade.getUf(), cidade.getCapital());
    }

    public Cidade toEntity() {
        Cidade cidade = new Cidade();
        cidade.setId(id);
        cidade.setNome(nome);
        cidade.setUf(uf);
        cidade.setCapital(capital);
        return cidade;
    }
}
