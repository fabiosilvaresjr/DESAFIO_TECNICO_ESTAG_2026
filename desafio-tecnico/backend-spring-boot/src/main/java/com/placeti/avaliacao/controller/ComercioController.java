package com.placeti.avaliacao.controller;

import com.placeti.avaliacao.dto.ComercioDTO;
import com.placeti.avaliacao.service.ComercioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comercios")
public class ComercioController {

    private final ComercioService comercioService;

    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComercioDTO> buscarPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(comercioService.pesquisarComercio(id));
    }

    @GetMapping
    public List<ComercioDTO> pesquisarComercios() {
        return comercioService.pesquisarComercios();
    }

    @PostMapping
    public void incluirComercio(@Valid @RequestBody ComercioDTO comercioDto) {
        comercioService.incluirComercio(comercioDto);
    }

    @PutMapping
    public void alterarComercio(@Valid @RequestBody ComercioDTO comercioDto) {
        comercioService.alterarComercio(comercioDto);
    }

    @DeleteMapping("/{id}")
    public void excluirComercio(@PathVariable Long id) {
        comercioService.excluirComercio(id);
    }
}
