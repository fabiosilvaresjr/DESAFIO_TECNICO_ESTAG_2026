package com.placeti.avaliacao.service;

import com.placeti.avaliacao.dto.ComercioDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.model.Comercio;
import com.placeti.avaliacao.model.TipoComercio;
import com.placeti.avaliacao.repository.CidadeRepository;
import com.placeti.avaliacao.repository.ComercioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComercioServiceTest {

    @Mock
    private ComercioRepository comercioRepository;

    @Mock
    private CidadeRepository cidadeRepository;

    @InjectMocks
    private ComercioService comercioService;

    @Test
    void deveIncluirComercioRelacionadoACidade() {
        Cidade cidade = new Cidade();
        cidade.setId(1L);

        when(cidadeRepository.findById(1L)).thenReturn(Optional.of(cidade));

        comercioService.incluirComercio(new ComercioDTO(null, "Padaria do Bairro", "Ana", TipoComercio.PADARIA, 1L));

        ArgumentCaptor<Comercio> captor = ArgumentCaptor.forClass(Comercio.class);
        verify(comercioRepository).save(captor.capture());
        assertEquals("Padaria do Bairro", captor.getValue().getNomeComercio());
        assertEquals("Ana", captor.getValue().getNomeResponsavel());
        assertEquals(TipoComercio.PADARIA, captor.getValue().getTipoComercio());
        assertEquals(1L, captor.getValue().getCidade().getId());
    }

    @Test
    void deveAlterarComercio() {
        Cidade cidadeAtual = new Cidade();
        cidadeAtual.setId(1L);

        Cidade novaCidade = new Cidade();
        novaCidade.setId(2L);

        Comercio comercio = new Comercio();
        comercio.setId(10L);
        comercio.setCidade(cidadeAtual);

        when(comercioRepository.findById(10L)).thenReturn(Optional.of(comercio));
        when(cidadeRepository.findById(2L)).thenReturn(Optional.of(novaCidade));

        comercioService.alterarComercio(new ComercioDTO(10L, "Posto Azul", "Carlos", TipoComercio.POSTO_GASOLINA, 2L));

        assertEquals("Posto Azul", comercio.getNomeComercio());
        assertEquals("Carlos", comercio.getNomeResponsavel());
        assertEquals(TipoComercio.POSTO_GASOLINA, comercio.getTipoComercio());
        assertEquals(2L, comercio.getCidade().getId());
        verify(comercioRepository).save(comercio);
    }
}
