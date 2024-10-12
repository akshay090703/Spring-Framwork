FROM amazoncorretto:21-alpine-jdk
COPY target/jobApp-0.0.1-SNAPSHOT.jar job-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "job-app.jar"]