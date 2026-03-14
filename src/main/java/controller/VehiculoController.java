package com.alquilatus.vehiculos.controller;

import com.alquilatus.vehiculos.model.EstadoVehiculo;
import com.alquilatus.vehiculos.model.Vehiculo;
import com.alquilatus.vehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping
    public String listarVehiculos(Model model) {
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "vehiculos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("estados", EstadoVehiculo.values());
        return "vehiculos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de vehículo no válido: " + id));

        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("estados", EstadoVehiculo.values());
        return "vehiculos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVehiculo(@PathVariable Long id) {
        vehiculoRepository.deleteById(id);
        return "redirect:/vehiculos";
    }
}