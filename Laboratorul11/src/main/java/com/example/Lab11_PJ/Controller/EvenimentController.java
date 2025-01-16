package com.example.Lab11_PJ.Controller;

import com.example.Lab11_PJ.Entity.Eveniment;
import com.example.Lab11_PJ.Entity.EvenimentNotFoundException;
import com.example.Lab11_PJ.Repository.EvenimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EvenimentController {

    @Autowired
    EvenimentRepository repository;

    @GetMapping("jpa/evenimente")
    public List<Eveniment> findAll() {
        List<Eveniment> lista=  repository.findAll();
        if(lista.isEmpty())
        {
            throw new EvenimentNotFoundException("Nu au fost gasite evenimente ");
    }
        else
            return lista;
    }

    @GetMapping("jpa/evenimente/locatie/{denumire_locatie}")
    public List<Eveniment> findByLocation(@PathVariable String denumire_locatie) {
        List<Eveniment> lista= repository.find_by_location(denumire_locatie);
        if(lista.isEmpty())
        {
            throw new EvenimentNotFoundException("Nu au fost gasite evenimente in locatia "+ denumire_locatie);
        }
        else
            return lista;
    }

    @GetMapping("jpa/evenimente/data/{data_eveniment}")
    public List<Eveniment> findByDate(@PathVariable LocalDate data_eveniment) {
        List<Eveniment> lista= repository.find_by_date(data_eveniment);
        if(lista.isEmpty())
        {
            throw new EvenimentNotFoundException("Nu au fost gasite evenimente in data: "+ data_eveniment);
        }
        else
            return lista;
    }

    @PostMapping("jpa/evenimente")
    public void saveEveniment(@RequestBody Eveniment eveniment) {
        repository.save(eveniment);
    }

    @PutMapping("jpa/evenimente")
    public void updateEveniment(@RequestBody Eveniment eveniment) {
        repository.save(eveniment);
    }

    @DeleteMapping("jpa/evenimente/id/{valoare_id}")
    public void deleteById(@PathVariable Long valoare_id) {
        repository.deleteById(valoare_id);
    }


}
