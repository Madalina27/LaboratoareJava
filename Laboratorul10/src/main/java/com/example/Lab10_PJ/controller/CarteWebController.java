package com.example.Lab10_PJ.controller;

import com.example.Lab10_PJ.entity.Carte;
import com.example.Lab10_PJ.repository.CarteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CarteWebController {
    @Autowired
    CarteRepository repository;
    @GetMapping("/lista-carti")
    public String getListaCarti(Model model)
    {
        String s="Lista cartilor preluate prin repository";
        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        model.addAttribute("carte",new Carte());

        return "carti";
    }
    @RequestMapping(value="/operatii",method= RequestMethod.POST,params = "adauga")
   //@PostMapping("/operatii")
    public String adaugare(@ModelAttribute Carte carte, Model model)
    {
        String s;
        if(carte.getTitlul().equals("") || carte.getAutorul().equals("")) {
            s = "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!\n";
        }
        else
        {
            repository.save(new Carte(null, carte.getTitlul(), carte.getAutorul()));
            s = "Adaugare realizata cu succes!";
        }

        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        model.addAttribute("carte",new Carte());
        return "carti";
    }


    @RequestMapping(value="/operatii",method= RequestMethod.POST,params = "modifica")
    public String modifica(@ModelAttribute Carte carte, Model model)
    {
        String s;
        if(carte.getISBN()!=null) {
            Optional<Carte> c = repository.findById(carte.getISBN());
            if (c.isEmpty()) {
                s = "Nu se gasete nici o carte cu isbn- ul introdus.";
            } else {
                if (carte.getTitlul().equals("")==false)
                    c.get().setTitlul(carte.getTitlul());
                if (carte.getAutorul().equals("")==false)
                    c.get().setAutorul(carte.getAutorul());
                repository.save(c.get());
                s = "Cartea cu ISBN" + carte.getISBN() + " a fost modificata!";
            }
        }
        else
            s = "Introduceti un ID";

        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        model.addAttribute("carte",new Carte());
        return "carti";
    }

    @RequestMapping(value="/operatii",method= RequestMethod.POST,params = "sterge")
    public String sterge(@ModelAttribute Carte carte, Model model)
    {
        String s;
        if(carte.getISBN()!=null) {
            Optional<Carte> c=repository.findById(carte.getISBN());
            if(c.isEmpty())
            {
                s="Nu se gasete nici o carte cu isbn-ul introdus.";
            }
            else
            {
                repository.deleteById(carte.getISBN());
                s="Cartea cu ISBN"+ carte.getISBN() + " a fost stearsa!";
            }
        }
        else
            s = "Introduceti un ID";
        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        model.addAttribute("carte",new Carte());
        return "carti";
    }

    @RequestMapping(value="/operatii",method= RequestMethod.POST,params = "filtreaza")
    public String filtreaza(@ModelAttribute Carte carte, Model model)
    {
        String s;
        if(!carte.getAutorul().isEmpty()) {
            List<Carte> lista=repository.find_all_by_autor(carte.getAutorul());
            if(lista.isEmpty())
            {
                s="Nu se gasete nici o carte cu autorul introdus.";
            }
            else
            {
                s="Cartile urmatoare apartin autorului "+ carte.getAutorul();
            }
            model.addAttribute("lista",lista);
        }
        else {
            s = "Introduceti un autor";
            model.addAttribute("lista",repository.findAll());
        }
        model.addAttribute("str",s);
        model.addAttribute("carte",new Carte());
        return "carti";
    }

}
