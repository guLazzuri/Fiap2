package br.com.fiap.epictaskg.task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PowerService {

    private final PowerRepository powerRepository;

    public PowerService(PowerRepository powerRepository) {
        this.powerRepository = powerRepository;
    }

    public List<Power> getAllTasks(){
        return  powerRepository.findAllByOrderByNivelInutilidadeDesc();
    }

}

