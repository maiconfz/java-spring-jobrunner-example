# syntax=docker/dockerfile:1
FROM gradle:jdk17-alpine AS builder
WORKDIR /home/gradle/app
COPY ./ ./
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY --from=builder /home/gradle/app/job-runner/build/libs/job-runner.jar /opt/app
EXPOSE 9000
CMD java -jar /opt/app/job-runner.jar
