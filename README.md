# Atividade RabbitMQ — Nota01 Sprint 2

Projeto desenvolvido para a atividade **Nota01 - Sprint 2 - 5º Semestre**.

## Participantes

* Igor Felix Latorre Simão (04251120)
* Manuela Miyuki Diogo Matsumoto (04251036)

## Sobre o projeto

O projeto demonstra a comunicação entre duas aplicações utilizando **RabbitMQ**.

* **Produtor:** recebe um pedido através de uma API e envia a mensagem para o RabbitMQ.
* **RabbitMQ:** recebe e encaminha a mensagem para a fila.
* **Consumidor:** recebe a mensagem da fila e exibe os dados do pedido no console.

A comunicação funciona da seguinte forma:

```text
Produtor → RabbitMQ → Consumidor
```

## Como executar

O arquivo `compose.yml` está dentro do projeto **produtor-rabbit** e é responsável por iniciar o RabbitMQ.

### 1. Acesse a pasta do produtor

```bash
cd produtor-rabbit
```

### 2. Inicie o RabbitMQ

```bash
docker compose up -d
```

### 3. Execute o projeto produtor

Inicie a aplicação `produtor-rabbit` pela IDE ou utilizando o Maven.

### 4. Execute o projeto consumidor

Inicie a aplicação `consumidor-rabbit`.

Com os dois projetos rodando, basta enviar um pedido para a API do produtor. A mensagem será enviada pelo RabbitMQ e recebida pelo consumidor.
