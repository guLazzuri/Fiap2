package com.lazzuri.CashPlus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazzuri.CashPlus.model.Credentiais;
import com.lazzuri.CashPlus.model.Token;
import com.lazzuri.CashPlus.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {


    @Autowired
    private AuthService authService
    ;


    @PostMapping("/login")
    public Token login(@RequestBody @Valid Credentiais credentiais) {
        log.info("Logando como:" + credentiais);
        return authService.login(credentiais);
    }

    


    
}
