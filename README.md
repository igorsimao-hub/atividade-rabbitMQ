# Atividade RabbitMQ — Nota01 Sprint 2

Projeto desenvolvido para a atividade **Nota01 - Sprint 2 - 5º Semestre**.

## Participantes

* Igor Felix Latorre Simão (04251120)
* Manuela Miyuki Diogo Matsumoto (04251036)

## Sobre o projeto

O projeto demonstra a comunicação entre **duas aplicações independentes** utilizando **RabbitMQ**.

* **Produtor:** aplicação Java com Spring Boot que recebe um pedido através de uma API e envia a mensagem para o RabbitMQ.
* **RabbitMQ:** responsável por receber e encaminhar as mensagens para a fila.
* **Consumidor:** aplicação Python que recebe a mensagem da fila e exibe os dados do pedido no console.

A comunicação funciona da seguinte forma:

```text
Produtor → RabbitMQ → Consumidor
```

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Python
* RabbitMQ
* Docker e Docker Compose

## Como executar

O arquivo `compose.yml` está na raiz do projeto e é responsável por iniciar todos os serviços necessários: **produtor, consumidor e RabbitMQ**.

Após baixar ou descompactar o projeto, não é necessário iniciar nenhuma aplicação manualmente.

### 1. Acesse a pasta do projeto

```bash
cd atividade-rabbitMQ
```

### 2. Inicie todos os serviços

```bash
docker compose up --build
```

O comando irá construir e iniciar automaticamente:

* RabbitMQ
* Aplicação produtora
* Aplicação consumidora

## Como testar a comunicação

Com os serviços em execução, envie um pedido para a API do produtor:

```text
POST http://localhost:8080/pedidos
```

Exemplo de corpo da requisição:

```json
{
  "id": 1,
  "nome": "Igor",
  "descricao": "Pedido de teste",
  "dataCriacao": "2026-10-04"
}
```

Após o envio, o produtor encaminha o pedido para o RabbitMQ, que entrega a mensagem ao consumidor.

Para visualizar a mensagem recebida pelo consumidor:

```bash
docker logs consumidor-rabbit
```

O consumidor exibirá os dados do pedido no console, confirmando a comunicação entre as duas aplicações através do RabbitMQ.
