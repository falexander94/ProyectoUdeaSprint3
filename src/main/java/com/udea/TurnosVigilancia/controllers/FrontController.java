package com.udea.TurnosVigilancia.controllers;

import com.udea.TurnosVigilancia.entity.Vigilante;
import com.udea.TurnosVigilancia.services.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    VigilanteService vigilanteService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }


    @GetMapping("Vigilants")
 public String vigilante(Model model){
        List<Vigilante> vigilantes = vigilanteService.getVigilante();
        model.addAttribute("vigilantes", vigilantes);
        return "vigilante";
 }


 @GetMapping("/Vigilants/newVigilant")
 public String newVigilant(Model model){
     model.addAttribute("vigilantes", new Vigilante());
    return "newVigilant";
 }

 @GetMapping("/vigilante/edit/{id}")
 public String editVigilante(@PathVariable Integer id,Model model){
        Vigilante vigilante = vigilanteService.getVigilanteById(id);
        if (vigilante != null){
            model.addAttribute("vigilante",vigilante);
            return "editVigilante";
        }else{
            return "redirect:/Vigilants";
        }
 }


}
