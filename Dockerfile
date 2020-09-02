FROM openjdk:8-jdk-alpine

ENV DOCKERIZE_VERSION v0.2.0
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ARG JAR_FILE=build/libs/subway-history-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY ./docker-entrypoint.sh docker-entrypoint.sh

RUN chmod +x docker-entrypoint.sh
ENTRYPOINT ./docker-entrypoint.sh
