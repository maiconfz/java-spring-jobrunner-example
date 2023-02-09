# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jre-alpine
RUN mkdir /opt/app
COPY ./job-runner/build/libs/job-runner.jar /opt/app
EXPOSE 9000
CMD ["java", "-jar", "/opt/app/job-runner.jar"]
