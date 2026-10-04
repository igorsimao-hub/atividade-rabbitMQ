package com.example.consumidor_rabbit;

import java.time.LocalDate;

public record Pedido(
        Long id,
        String nome,
        String descricao,
        LocalDate dataCriacao
) {
}