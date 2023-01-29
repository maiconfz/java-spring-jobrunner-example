package io.github.maiconfz.java_spring_jobrunner_example.job_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.tinylog.Logger;

import io.github.maiconfz.java_spring_jobrunner_example.job_runner.config.JobRunrStorageConfiguration;

@SpringBootApplication
@Import(JobRunrStorageConfiguration.class)
public class App {
    public static void main(String[] args) {
        Logger.info("Initializing App...");
        SpringApplication.run(App.class, args);
    }
}
