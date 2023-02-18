# syntax=docker/dockerfile:1
FROM gradle:jdk17-alpine AS builder
ARG APPLICATION_YML_PATH
RUN echo "APPLICATION_YML_PATH=$APPLICATION_YML_PATH"
WORKDIR /home/gradle/app
COPY ./ ./
COPY $APPLICATION_YML_PATH ./job-runner/src/main/resources/application.yml
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jre-alpine
ARG SPRING_PROFILE=default
RUN echo "SPRING_PROFILE=$SPRING_PROFILE"
WORKDIR /opt/app
COPY --from=builder /home/gradle/app/job-runner/build/libs/job-runner.jar /opt/app
EXPOSE 9000
CMD ["java", "-jar", "/opt/app/job-runner.jar"]
