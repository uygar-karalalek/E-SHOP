FROM openjdk:16-alpine3.13
ARG JAR_FILE
VOLUME /tmp

ENV jar=${JAR_FILE}

COPY ./rest/build/libs/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 80