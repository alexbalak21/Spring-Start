FROM openjdk:26-ea-21-slim
VOLUME /tmp
COPY target/app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
