package com.alquilatus.vehiculos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String inicio() {
        return "AlquilaTusVehiculos funcionando correctamente 🚗";
    }
}