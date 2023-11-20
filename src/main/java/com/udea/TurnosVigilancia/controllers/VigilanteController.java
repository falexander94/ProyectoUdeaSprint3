package com.udea.TurnosVigilancia.controllers;


import com.udea.TurnosVigilancia.entity.Vigilante;
import com.udea.TurnosVigilancia.repository.VigilanteRepository;
import com.udea.TurnosVigilancia.services.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
public class VigilanteController {
    @Autowired
    private VigilanteService vigilanteService;

    @PostMapping("/addVigilante")
    public RedirectView saveVigilante(@ModelAttribute Vigilante vigilante, Model model){
        model.addAttribute("vigilante");
        vigilanteService.saveVigilante(vigilante);
        return new RedirectView("Vigilants");

    }
    /*
    @GetMapping("/Vigilants")
    public List<Vigilante> findAllVigilants(){

        return  vigilanteService.getVigilante();
    }*/


    @GetMapping("/Vigilante/{id}")
    public Vigilante findByID(@PathVariable Integer id){
        return vigilanteService.getVigilanteById(id);
    }

    @PostMapping("/addVigilants")
    public List<Vigilante> saveVigilants(@RequestBody List<Vigilante> vigilants){
        return vigilanteService.saveVigilants(vigilants);
    }

    /*
    @PutMapping("/updateVigilante")
    public  Vigilante updateVigilante(@RequestBody Vigilante vigilante){
        return vigilanteService.updateVigilante(vigilante);
    }*/

    @DeleteMapping("/Vigilant/{id}")
    public RedirectView deleteVigilante(@PathVariable Integer id){
        vigilanteService.deleteVigilante(id);

        return new RedirectView("Vigilants");
    }

    @PatchMapping("/Vigilant/{id}")
    public  RedirectView updateVigilante(@PathVariable("id")Integer id){
        vigilanteService.markVigilanteDisponible(id);
        return  new RedirectView("/Vigilants");
    }


    @PostMapping("/Vigilante/update")
    public  RedirectView updateVigilante(@ModelAttribute Vigilante vigilante){
        vigilanteService.updateVigilante(vigilante);
        return new RedirectView("/Vigilants");
    }
   }

