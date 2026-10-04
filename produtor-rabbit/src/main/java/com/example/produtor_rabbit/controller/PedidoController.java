package com.example.produtor_rabbit.controller;

import com.example.produtor_rabbit.Pedido;
import com.example.produtor_rabbit.RabbitBeanConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;

    public PedidoController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> enviar(@RequestBody Pedido pedido) {

        rabbitTemplate.convertAndSend(RabbitBeanConfiguration.EXCHANGE_PEDIDO, RabbitBeanConfiguration.ROUTING_KEY, pedido);
        return ResponseEntity.accepted().build();
    }
}