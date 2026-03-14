package com.alquilatus.vehiculos.repository;

import com.alquilatus.vehiculos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}