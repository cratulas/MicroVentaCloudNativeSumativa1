package com.example.microventa.repository;

import com.example.microventa.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
