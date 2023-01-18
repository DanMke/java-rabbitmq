FROM maven:3-openjdk-17

ENV RABBITMQ_HOST=rabbitmq
ENV RABBITMQ_PORT=5672
ENV RABBITMQ_USER=guest
ENV RABBITMQ_PASSWORD=guest
ENV ORDER_EXCHANGE=order.exchange
ENV ORDER_QUEUE=order.queue
ENV ORDER_ROUTINGKEY=order.routingkey

WORKDIR /app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run