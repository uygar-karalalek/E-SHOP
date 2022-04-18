FROM openjdk:16-alpine3.13
RUN apk update && apk add bash

ARG JAR_FILE
VOLUME /tmp

ENV jar=${JAR_FILE}

COPY ./rest/build/libs/${JAR_FILE} app.jar
COPY ./wait_mysql.sh ./wait_mysql.sh

RUN ["chmod", "+x", "./wait_mysql.sh"]
ENTRYPOINT ["./wait_mysql.sh", "eshop-database:3306", "-t", "200","--", "java", "-jar", "/app.jar"]