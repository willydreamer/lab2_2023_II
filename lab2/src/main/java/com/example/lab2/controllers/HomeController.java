package com.example.lab2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String paginaPrincipal(){
        return "hola ciclo 2023-2 :D";
    }

    @RequestMapping(value = {"/gaa"})
    public String empleado(){
        return "pag1";
    }
}
