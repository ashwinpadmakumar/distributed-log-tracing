FROM adoptopenjdk/openjdk11-openj9 as builder
RUN apt-get update
RUN apt-get install haveged unzip -y

WORKDIR /sleuth-client/service

ENV CATALINA_OPTS="-Djava.rmi.server.hostname=localhost"

EXPOSE 8081