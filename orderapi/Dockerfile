FROM maven:3-openjdk-17

ENV MONGODB_AUTHENTICATION_DATABASE=admin
ENV MONGODB_USER=root
ENV MONGODB_PASSWORD=root
ENV MONGODB_DATABASE=OrderDB
ENV MONGODB_PORT=27017
ENV MONGODB_HOST=mongo
ENV SERVER_PORT=8083

WORKDIR /app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run