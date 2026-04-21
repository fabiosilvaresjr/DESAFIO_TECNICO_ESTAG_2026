package com.placeti.avaliacao.service;

import com.placeti.avaliacao.dto.ComercioDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.model.Comercio;
import com.placeti.avaliacao.repository.CidadeRepository;
import com.placeti.avaliacao.repository.ComercioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {

    private final ComercioRepository comercioRepository;
    private final CidadeRepository cidadeRepository;

    public ComercioService(ComercioRepository comercioRepository, CidadeRepository cidadeRepository) {
        this.comercioRepository = comercioRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public ComercioDTO pesquisarComercio(Long id) {
        return comercioRepository.findById(id)
                .map(ComercioDTO::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Comercio nao encontrado para o id " + id));
    }

    public List<ComercioDTO> pesquisarComercios() {
        return comercioRepository.findAll().stream()
                .map(ComercioDTO::fromEntity)
                .toList();
    }

    public void incluirComercio(ComercioDTO dto) {
        Comercio comercio = new Comercio();
        preencherComercio(comercio, dto);
        comercio.setId(null);
        comercioRepository.save(comercio);
    }

    public void alterarComercio(ComercioDTO dto) {
        if (dto.id() == null) {
            throw new IllegalArgumentException("Id do comercio deve ser informado para alteracao");
        }
        Comercio comercio = comercioRepository.findById(dto.id())
                .orElseThrow(() -> new IllegalArgumentException("Comercio nao encontrado para o id " + dto.id()));
        preencherComercio(comercio, dto);
        comercioRepository.save(comercio);
    }

    public void excluirComercio(Long id) {
        comercioRepository.deleteById(id);
    }

    private void preencherComercio(Comercio comercio, ComercioDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.cidadeId())
                .orElseThrow(() -> new IllegalArgumentException("Cidade nao encontrada para o id " + dto.cidadeId()));
        comercio.setNomeComercio(dto.nomeComercio());
        comercio.setNomeResponsavel(dto.nomeResponsavel());
        comercio.setTipoComercio(dto.tipoComercio());
        comercio.setCidade(cidade);
    }
}
