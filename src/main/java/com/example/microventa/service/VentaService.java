package com.example.microventa.service;

import com.example.microventa.model.Venta;
import com.example.microventa.repository.VentaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import com.example.microventa.config.RabbitMQConfig;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final RabbitTemplate rabbitTemplate;

    public VentaService(VentaRepository ventaRepository, RabbitTemplate rabbitTemplate) {
        this.ventaRepository = ventaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Venta registrarVenta(Venta venta) {
        venta.getDetalles().forEach(det -> det.setVenta(venta));
        Venta ventaGuardada = ventaRepository.save(venta);

        rabbitTemplate.convertAndSend(
                "", // Cola directa
                RabbitMQConfig.VENTAS_QUEUE,
                ventaGuardada
        );

        return ventaGuardada;
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }
}
