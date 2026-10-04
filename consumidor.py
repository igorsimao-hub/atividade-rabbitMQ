import pika
import json
import time

while True:
    try:
        connection = pika.BlockingConnection(
            pika.ConnectionParameters(
                host="rabbitmq",
                port=5672,
                credentials=pika.PlainCredentials("admin", "admin")
            )
        )
        break
    except pika.exceptions.AMQPConnectionError:
        print("RabbitMQ ainda não está disponível. Tentando novamente...")
        time.sleep(5)

channel = connection.channel()

channel.queue_declare(queue="queue_pedido", durable=True)


def receber(ch, method, properties, body):
    pedido = json.loads(body)

    print("Pedido Recebido!", flush=True)
    print("    ID:", pedido["id"], flush=True)
    print("    nome:", pedido["nome"], flush=True)
    print("    descricao:", pedido["descricao"], flush=True)
    print("    data:", pedido["dataCriacao"], flush=True)

    ch.basic_ack(delivery_tag=method.delivery_tag)


channel.basic_consume(
    queue="queue_pedido",
    on_message_callback=receber
)

print("Consumidor aguardando mensagens...", flush=True)

channel.start_consuming()