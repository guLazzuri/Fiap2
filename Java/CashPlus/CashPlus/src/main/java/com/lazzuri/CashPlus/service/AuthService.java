package com.lazzuri.CashPlus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lazzuri.CashPlus.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService{

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        var user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username, null));
        return user;
    }
    
}
