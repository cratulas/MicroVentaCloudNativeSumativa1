package com.example.microventa.service;

import com.example.microventa.config.RabbitMQConfig;
import com.example.microventa.model.Venta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final RabbitTemplate rabbitTemplate;

    public VentaService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Venta registrarVenta(Venta venta) {
        rabbitTemplate.convertAndSend(
            "", // default exchange
            RabbitMQConfig.VENTAS_QUEUE,
            venta
        );
        return venta;
    }

    public List<Venta> listarVentas() {
        return List.of();
    }
}
