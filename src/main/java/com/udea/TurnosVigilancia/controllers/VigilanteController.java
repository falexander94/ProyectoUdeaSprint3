package com.udea.TurnosVigilancia.controllers;


import com.udea.TurnosVigilancia.entity.Vigilante;
import com.udea.TurnosVigilancia.services.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VigilanteController {
    @Autowired
    private VigilanteService vigilanteService;

    @PostMapping("/addVigilante")
    public Vigilante saveVigilante(@RequestBody Vigilante vigilante){
        return vigilanteService.saveVigilante(vigilante);

    }
    @GetMapping("/Vigilants")
    public List<Vigilante> findAllVigilants(){

        return  vigilanteService.getVigilante();
    }


    @GetMapping("/Vigilante/{id}")
    public Vigilante findByID(@PathVariable Integer id){
        return vigilanteService.getVigilanteById(id);
    }

    @PostMapping("/addVigilants")
    public List<Vigilante> saveVigilants(@RequestBody List<Vigilante> vigilants){
        return vigilanteService.saveVigilants(vigilants);
    }

    @PutMapping("/updateVigilante")
    public  Vigilante updateVigilante(@RequestBody Vigilante vigilante){
        return vigilanteService.updateVigilante(vigilante);
    }

    @DeleteMapping("/deleteVigilante/{id}")
    public String deleteVigilante(@PathVariable Integer id){
        return vigilanteService.deleteVigilante(id);
    }

   }

