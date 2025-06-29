package com.example.microventa.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductoClient {

    private final RestTemplate restTemplate;

    public ProductoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void descontarStock(Long productoId, int cantidad) {
        String url = "http://microproducto:8081/productos/" + productoId + "/descontar/" + cantidad;
        restTemplate.put(url, null);
    }
}
