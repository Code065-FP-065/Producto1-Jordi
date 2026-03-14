package com.alquilatus.vehiculos.repository;

import com.alquilatus.vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}