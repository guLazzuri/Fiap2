package br.com.fiap.cash_up_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cash_up_api.model.Bank;

@RestController // component
public class BankController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private List<Bank> repository = new ArrayList<>();

    // GET

    @GetMapping("/account/{id}")
    public ResponseEntity<Bank> get(@PathVariable Long id) {
        log.info("Fetching account " + id);
        return ResponseEntity.ok(getBank(id));
    }

    @GetMapping("/account/cpf/{cpf}")
    public ResponseEntity<Bank> getByCpf(@PathVariable Long cpf) {
        log.info("Fetching account with CPF " + cpf);
        return ResponseEntity.ok(getBankByCpf(cpf));
    }

    @GetMapping("/account")
    public List<Bank> index() {
        log.info("Fetching all accounts");
        return repository;
    }

    // POST

    @PostMapping("/account")
    public ResponseEntity<Bank> create(@RequestBody Bank bank) {
        repository.add(bank);
        log.info("Account created");

        return ResponseEntity.status(201).body(bank);
    }

    // DELETE

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("Deleting account " + id);
        repository.remove(getBank(id));
        return ResponseEntity.noContent().build();
    }

    // PUT


    @PutMapping("/account/{id}/status/{status}")
    public ResponseEntity<Bank> updateStatus(@PathVariable Long id, @PathVariable boolean status) {
        log.info("Updating status of account " + id + " to " + status);
        var bankToUpdate = getBank(id);
        repository.remove(bankToUpdate);
        bankToUpdate.setIsActive(status);
        repository.add(bankToUpdate);
        return ResponseEntity.ok(bankToUpdate);
    }

    @PutMapping("/account/{id}/balance/deposit/{balance}")
    public ResponseEntity<Bank> depositBalance(@PathVariable Long id, @PathVariable double balance) {
        log.info("Depositing " + balance + " to account " + id);
        var bankToUpdate = getBank(id);
        repository.remove(bankToUpdate);
        bankToUpdate.setBalance(bankToUpdate.getBalance() + balance);
        repository.add(bankToUpdate);
        return ResponseEntity.ok(bankToUpdate);
    }

    @PutMapping("/account/{id}/balance/withdrawal/{balance}")
    public ResponseEntity<Bank> withdrawBalance(@PathVariable Long id, @PathVariable double balance) {
        log.info("Withdrawing " + balance + " from account " + id);
        var bankToUpdate = getBank(id);
        repository.remove(bankToUpdate);
        bankToUpdate.setBalance(bankToUpdate.getBalance() - balance);
        repository.add(bankToUpdate);
        return ResponseEntity.ok(bankToUpdate);
    }


    @PutMapping("/account/pix/{id}/{balance}/{idPix}")
    public ResponseEntity<Bank> pix(@PathVariable Long id, @PathVariable double balance, @PathVariable Long idPix) {
        log.info("Performing pix from account " + id + " of $" + balance + " to account " + idPix);

        var accountCredit = getBank(id);
        var accountDebit = getBank(idPix);
        repository.remove(accountCredit);
        repository.remove(accountDebit);
        accountCredit.setBalance(accountCredit.getBalance() - balance);
        accountDebit.setBalance(accountDebit.getBalance() + balance);

        repository.add(accountCredit);
        repository.add(accountDebit);
        return ResponseEntity.ok(accountCredit);
    }

    private Bank getBank(Long id) {
        return repository.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Account not found"));
    }

    private Bank getBankByCpf(Long cpf) {
        return repository.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Account not found"));
    }
}