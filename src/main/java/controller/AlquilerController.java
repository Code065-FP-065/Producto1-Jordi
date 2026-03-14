package com.alquilatus.vehiculos.controller;

import com.alquilatus.vehiculos.repository.AlquilerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlquilerController {

    private final AlquilerRepository alquilerRepository;

    public AlquilerController(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @GetMapping("/alquileres")
    public String listarAlquileres(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        return "alquileres/lista";
    }
}