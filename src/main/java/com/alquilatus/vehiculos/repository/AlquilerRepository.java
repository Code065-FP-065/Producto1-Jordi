package com.alquilatus.vehiculos.repository;

import com.alquilatus.vehiculos.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}