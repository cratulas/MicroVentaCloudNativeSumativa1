package com.example.microventa.service;

import com.example.microventa.model.DetalleVenta;
import com.example.microventa.model.Venta;
import com.example.microventa.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Venta registrarVenta(Venta venta) {
        venta.setFecha(LocalDateTime.now());

        for (DetalleVenta detalle : venta.getDetalles()) {
            detalle.setVenta(venta); 
            descontarStock(detalle.getProductoId(), detalle.getCantidad());
        }

        return ventaRepository.save(venta);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    private void descontarStock(Long productoId, int cantidad) {
        String url = "http://localhost:8081/productos/" + productoId + "/descontar/" + cantidad;
        restTemplate.put(url, null);
    }
}
