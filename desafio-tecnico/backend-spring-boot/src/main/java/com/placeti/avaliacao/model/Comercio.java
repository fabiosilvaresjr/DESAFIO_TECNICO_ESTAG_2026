package com.placeti.avaliacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME_COMERCIO", length = 100, nullable = false)
    private String nomeComercio;

    @Column(name = "NOME_RESPONSAVEL", length = 100, nullable = false)
    private String nomeResponsavel;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_COMERCIO", length = 30, nullable = false)
    private TipoComercio tipoComercio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    private Cidade cidade;
}
