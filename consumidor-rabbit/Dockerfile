FROM python:3.12-slim

WORKDIR /app

COPY consumidor.py .

RUN pip install pika

CMD ["python", "consumidor.py"]