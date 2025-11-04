FROM openjdk:26-ea-21-slim
VOLUME /tmp
COPY target/app-build.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
