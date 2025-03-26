package br.com.fiap.cash_go.controller;

import br.com.fiap.cash_go.model.Account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private List<Account> repository = new ArrayList<>();

    @GetMapping("/accounts")
    public List<Account> index() {
        return repository;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        System.out.println("Cadastrando conta: " + account.getName());
        repository.add(account);
        return ResponseEntity.status(201).body(account);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> get(@PathVariable long id) {
        System.out.println("Buscando conta: " + id);
        var account = repository.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst();

        if (account.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(account.get());
    }
}