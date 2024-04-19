package com.example.demo.controllers;


import com.example.demo.services.EstudianteService;
import com.example.demo.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

}
