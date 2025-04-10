package com.lazzuri.CashPlus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lazzuri.CashPlus.model.Assets;
import com.lazzuri.CashPlus.repository.AssetsRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/assets")
@Slf4j
public class AssetsController {

    @Autowired
    private AssetsRepository repository;

    // Listar todos os ativos
    @GetMapping
    @Cacheable("assets")
    @Operation(
            description = "Listar todos os ativos",
            tags = "assets",
            summary = "Lista de Ativos"
    )
    public List<Assets> index() {
        log.info("Buscando todos os ativos");
        return repository.findAll();
    }

    // Cadastrar um ativo
    @PostMapping
    @CacheEvict(value = "assets", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na Validação")
    })
    public Assets create(@RequestBody @Valid Assets assets) {
        log.info("Cadastrando ativo: " + assets.getName());
        return repository.save(assets);
    }

    // Retornar um ativo pelo ID
    @GetMapping("{id}")
    public Assets get(@PathVariable Long id) {
        log.info("Buscando ativo com ID: " + id);
        return getAssets(id);
    }

    // Deletar um ativo pelo ID
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando ativo com ID: " + id);
        repository.delete(getAssets(id));
    }

    // Atualizar um ativo pelo ID
    @PutMapping("{id}")
    public Assets update(@PathVariable Long id, @RequestBody @Valid Assets assets) {
        log.info("Atualizando ativo com ID: " + id + " " + assets);
        getAssets(id);
        assets.setId(id);
        return repository.save(assets);
    }

    // Método auxiliar para buscar um ativo pelo ID
    private Assets getAssets(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ativo não encontrado"));
    }
}