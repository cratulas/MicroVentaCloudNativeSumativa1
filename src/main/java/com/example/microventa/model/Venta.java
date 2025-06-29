package com.example.microventa.model;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private LocalDateTime fecha = LocalDateTime.now();
    private List<DetalleVenta> detalles;

    // Getters y Setters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
