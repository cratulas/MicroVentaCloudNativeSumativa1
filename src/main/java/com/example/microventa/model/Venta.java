package com.example.microventa.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha = LocalDateTime.now();

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleVenta> detalles;

}
