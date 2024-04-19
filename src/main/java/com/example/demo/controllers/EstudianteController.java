package com.example.demo.controllers;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.services.EstudianteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class EstudianteController {


    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/lista")
    public String lista(Model modelo) {
        Iterable<Estudiante> estudiantes = estudianteService.listar();
        modelo.addAttribute("estudiantes", estudiantes);
        return "estudianteAdmin/lista";
    }

    @GetMapping({"/formulario-crear", "/agregar" , "/borrar"} )
    public String mostrarFormularioCreacion(Model modelo, HttpServletRequest request) {
        modelo.addAttribute("estudiante", new Estudiante());
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/formulario-crear")) {
            return "crearEstudiante";
        } else if (requestURI.equals("/agregar")) {
            return "estudianteAdmin/agregar";
        }
     else if (requestURI.equals("/borrar")) {
        return "estudianteAdmin/borrar";
    }
        return "crearEstudiante";
    }

    @PostMapping("/estudiante/crear1")
    @ResponseBody
    public ResponseEntity<String> crearEstudiante(@ModelAttribute Estudiante estudiante) {
        try {
            estudianteService.registrar(estudiante);
            return ResponseEntity.ok("Estudiante registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar estudiante");
        }
    }




    @PostMapping("/estudiante/crear")
    public RedirectView crearEstudiante(@ModelAttribute Estudiante estudiante, RedirectAttributes redirectAttributes) {
        estudianteService.registrar(estudiante);
        redirectAttributes.addFlashAttribute("mensaje", "Estudiante registrado correctamente");
        return new RedirectView("/lista");
    }
}