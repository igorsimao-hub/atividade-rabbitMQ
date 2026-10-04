package com.example.consumidor_rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

    @RabbitListener(queues = RabbitBeanConfiguration.QUEUE_PEDIDO)
    public void receber(Pedido pedido) {

        System.out.println("Pedido Recebido!");
        System.out.println("    ID: " + pedido.id());
        System.out.println("    nome: " + pedido.nome());
        System.out.println("    descricao: " + pedido.descricao());
        System.out.println("    data: " + pedido.dataCriacao());
    }
}