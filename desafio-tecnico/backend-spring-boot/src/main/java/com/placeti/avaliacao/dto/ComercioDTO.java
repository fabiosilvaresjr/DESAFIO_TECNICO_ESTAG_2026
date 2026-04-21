package com.placeti.avaliacao.dto;

import com.placeti.avaliacao.model.Comercio;
import com.placeti.avaliacao.model.TipoComercio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ComercioDTO(
        Long id,

        @NotBlank
        @Size(max = 100)
        String nomeComercio,

        @NotBlank
        @Size(max = 100)
        String nomeResponsavel,

        @NotNull
        TipoComercio tipoComercio,

        @NotNull
        Long cidadeId
) {

    public static ComercioDTO fromEntity(Comercio comercio) {
        return new ComercioDTO(
                comercio.getId(),
                comercio.getNomeComercio(),
                comercio.getNomeResponsavel(),
                comercio.getTipoComercio(),
                comercio.getCidade().getId()
        );
    }
}
