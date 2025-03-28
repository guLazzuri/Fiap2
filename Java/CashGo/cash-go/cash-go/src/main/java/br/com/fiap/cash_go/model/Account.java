package main.java.br.com.fiap.cash_go.model;

import java.util.Random;

public class Account {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        try {
            this.id = id;          
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            this.name = name;          
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    





    
}
