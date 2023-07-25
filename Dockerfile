FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8443

COPY build/libs/rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]