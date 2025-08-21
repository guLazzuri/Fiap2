package br.com.fiap.epictaskg.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository repository;

    public List<Character> listAll() {
        return repository.findAll();
    }

    public void save(Character character) {
        repository.save(character);
    }
}
