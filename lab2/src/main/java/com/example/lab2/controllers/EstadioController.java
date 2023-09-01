package com.example.lab2.controllers;

import com.example.lab2.entity.Estadio;
import com.example.lab2.repository.EstadioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/estadio")
public class EstadioController {

    final EstadioRepository estadioRepository;

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }


    @GetMapping(value = {"/","listar"})
    public String listaEstadios (Model model){
        model.addAttribute("lista", estadioRepository.findAll());
        return "estadio/list";
    };

    @GetMapping(value="nuevo")
    public String nuevoEstadio(){ return "estadio/newForm";};

    @PostMapping("guardar")
    public String guardarEstadio(Estadio estadio){
        estadioRepository.save(estadio);
        return "redirect:/estadio/listar";
    };

    @GetMapping("borrar")
    public String borrarEstadio(@RequestParam("id") int id){
        Optional<Estadio> optional = estadioRepository.findById(id);

        if (optional.isPresent()) {
            estadioRepository.deleteById(id);
        }
        return "redirect:/estadio/listar";
    };
}