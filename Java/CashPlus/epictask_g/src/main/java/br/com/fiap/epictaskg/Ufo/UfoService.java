package br.com.fiap.epictaskg.Ufo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UfoService {

    private final UfoRepository ufoRepository;

    public UfoService(UfoRepository ufoRepository) {
        this.ufoRepository = ufoRepository;
    }

    public List<Ufo> getAllUfos(){
        return ufoRepository.findAll();
    }

    public Ufo save(Ufo ufo) {
        return ufoRepository.save(ufo);
    }
}
