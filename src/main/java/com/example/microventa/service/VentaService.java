package com.example.microventa.service;

import com.example.microventa.client.ProductoClient;
import com.example.microventa.config.RabbitMQConfig;
import com.example.microventa.model.DetalleVenta;
import com.example.microventa.model.Venta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final RabbitTemplate rabbitTemplate;
    private final ProductoClient productoClient;

    public VentaService(RabbitTemplate rabbitTemplate, ProductoClient productoClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.productoClient = productoClient;
    }

    public Venta registrarVenta(Venta venta) {
        for (DetalleVenta detalle : venta.getDetalles()) {
            productoClient.descontarStock(detalle.getProductoId(), detalle.getCantidad());
        }

        rabbitTemplate.convertAndSend(
            "",
            RabbitMQConfig.VENTAS_QUEUE,
            venta
        );
        return venta;
    }

    public List<Venta> listarVentas() {
        return List.of();
    }
}
