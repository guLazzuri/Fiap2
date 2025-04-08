package com.lazzuri.CashPlus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/assets")
public class AssetsController {

    private final Logger log =  LoggerFactory.getLogger(AssetsController.class);

    @Autowired
    private AssetsRepository repository;

    /**
     * Método para listar todos os ativos de investimento.
     * Utiliza cache para melhorar o desempenho.
     * @return Lista de todos os ativos.
     */
    @GetMapping
    @Cacheable("assets")
    @Operation(description = "Listar todas as investimentos", tags = "assets", summary = "Lista de investimentos")
    public List<Assets> index() {
        log.info("Buscando todas investimentos");
        return repository.findAll();
    }

    /**
     * Método para criar um novo ativo de investimento.
     * Invalida o cache após a criação.
     * @param assets Objeto do ativo a ser criado.
     * @return O ativo criado.
     */
    @PostMapping
    @CacheEvict(value = "assets", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Falha na validação")
    })
    public Assets create(@RequestBody @Valid Assets assets) {
        log.info("Cadastrando investimento " + assets.getName());
        return repository.save(assets);
    }

    /**
     * Método para buscar um ativo de investimento pelo ID.
     * @param id ID do ativo a ser buscado.
     * @return O ativo encontrado.
     */
    @GetMapping("{id}")
    public Assets get(@PathVariable Long id) {
        log.info("Buscando investimento " + id);
        return getAssets(id);
    }

    /**
     * Método para deletar um ativo de investimento pelo ID.
     * @param id ID do ativo a ser deletado.
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando investimento " + id);
        repository.delete(getAssets(id));
    }

    /**
     * Método para atualizar um ativo de investimento pelo ID.
     * @param id ID do ativo a ser atualizado.
     * @param assets Objeto com os novos dados do ativo.
     * @return O ativo atualizado.
     */
    @PutMapping("{id}")
    public Assets update(@PathVariable Long id, @RequestBody @Valid Assets assets) {
        log.info("Atualizando investimento " + id + " " + assets);

        getAssets(id);
        assets.setId(id);
        return repository.save(assets);
    }

    /**
     * Método auxiliar para buscar um ativo pelo ID.
     * Lança uma exceção caso o ativo não seja encontrado.
     * @param id ID do ativo a ser buscado.
     * @return O ativo encontrado.
     */
    private Assets getAssets(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "investimento não encontrada"));
    }
}