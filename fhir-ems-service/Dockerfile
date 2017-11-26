FROM maven:3-jdk-8-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

ADD . /usr/src/app

CMD ["mvn", "clean", "spring-boot:run"]

EXPOSE 8080
