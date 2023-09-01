package com.example.lab2.controllers;

import com.example.lab2.entity.Jugador;
import com.example.lab2.repository.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/jugador")
public class HomeController {

    final JugadorRepository jugadorRepository;

    public HomeController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String paginaPrincipal(){
        return "Este mesaje aparenetemenete deberia traer alegria, pero nooooo, la verdad no se que decir, arriba perú";
    }

    @GetMapping(value = {"","listar"})
    public String listaJugadores (Model model){
        model.addAttribute("lista", jugadorRepository.findAll());
        return "jugador/list";
    };

    @GetMapping(value="nuevo")
    public String nuevoJugador(){ return "jugador/newForm";};

    @PostMapping("guardar")
    public String guardarJugador(Jugador jugador){
        jugadorRepository.save(jugador);
        return "redirect:/jugador/listar";
    };

    @GetMapping("borrar")
    public String borrarJugador(@RequestParam("id") int id){
        Optional<Jugador> optional = jugadorRepository.findById(id);

        if (optional.isPresent()) {
            jugadorRepository.deleteById(id);
        }
        return "redirect:/jugador/listar";
    };
}
