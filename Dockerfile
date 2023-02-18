# syntax=docker/dockerfile:1
FROM gradle:8-jdk17-alpine AS builder
ARG APPLICATION_YML_FOLDER_PATH
RUN echo "APPLICATION_YML_FOLDER_PATH=$APPLICATION_YML_FOLDER_PATH"
WORKDIR /home/gradle/app
COPY ./ ./
COPY $APPLICATION_YML_FOLDER_PATH/* ./job-runner/src/main/resources/
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY --from=builder /home/gradle/app/job-runner/build/libs/job-runner.jar /opt/app
EXPOSE 9000
ENTRYPOINT [ "java", "-jar", "/opt/app/job-runner.jar"]