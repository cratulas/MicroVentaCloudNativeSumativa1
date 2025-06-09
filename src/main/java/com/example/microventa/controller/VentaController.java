package com.example.microventa.controller;

import com.example.microventa.model.Venta;
import com.example.microventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta registrar(@RequestBody Venta venta) {
        return ventaService.registrarVenta(venta);
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaService.listarVentas();
    }
}
