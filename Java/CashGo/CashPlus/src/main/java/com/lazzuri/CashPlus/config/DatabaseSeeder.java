package com.lazzuri.CashPlus.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.lazzuri.CashPlus.model.Assets;
import com.lazzuri.CashPlus.model.Transaction;
import com.lazzuri.CashPlus.model.TransactionType;
import com.lazzuri.CashPlus.repository.AssetsRepository;
import com.lazzuri.CashPlus.repository.TransactionRepository;

import jakarta.annotation.PostConstruct;

public class DatabaseSeeder {

    @Autowired
    private AssetsRepository assetsRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostConstruct
    public void init(){

        var assets = List.of(
            Assets.builder().name("Gold").symbol("Gold").price(200).quantity(5).build(),
            Assets.builder().name("Bitcoin").symbol("BTC").price(300).quantity(2).build(),
            Assets.builder().name("Ethereum").symbol("ETH").price(400).quantity(3).build(),
            Assets.builder().name("Petrobras").symbol("Money").price(500).quantity(4).build()
        );

        assetsRepository.saveAll(assets);

        

        var description = List.of(
            "Compra de ações da Apple",
    "Compra de ações da Tesla",
    "Investimento em fundos imobiliários",
    "Compra de títulos do governo",
    "Investimento em criptomoedas",
    "Compra de ações da Amazon",
    "Compra de ações da Microsoft",
    "Investimento em startups",
    "Compra de ações da Petrobras",
    "Compra de ações da Vale",
    "Investimento em ETFs",
    "Compra de ações do Google",
    "Compra de ações da Netflix",
    "Investimento em ouro",
    "Compra de ações da Meta (Facebook)",
    "Investimento em renda fixa",
    "Compra de ações da Disney",
    "Compra de ações da Coca-Cola",
    "Investimento em commodities",
    "Compra de ações da IBM"
            );


        var transactions = new ArrayList<Transaction>();

        for (int i = 0; i < 50; i++) {
            transactions.add(Transaction.builder()
                    .description(description.get(new Random().nextInt(description.size())))
                    .amount(BigDecimal.valueOf(new Random().nextDouble() * 500))
                    .date(LocalDate.now().minusDays(new Random().nextInt(30)))
                    .type(TransactionType.EXPENSE)
                    .assets(assets.get(new Random().nextInt(assets.size())))
                    .build());
        }
        transactionRepository.saveAll(transactions);
        
        
        
    }
    
}
