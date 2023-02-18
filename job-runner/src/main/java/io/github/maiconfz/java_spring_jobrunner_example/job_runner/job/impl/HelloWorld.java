package io.github.maiconfz.java_spring_jobrunner_example.job_runner.job.impl;

import org.jobrunr.jobs.context.JobRunrDashboardLogger;
import org.jobrunr.spring.annotations.Recurring;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.maiconfz.java_spring_jobrunner_example.job_runner.job.Job;

@Component
public class HelloWorld implements Job {
    private static final org.slf4j.Logger JOBRUNNR_LOGGER = new JobRunrDashboardLogger(
            LoggerFactory.getLogger(HelloWorld.class));

    @Override
    @org.jobrunr.jobs.annotations.Job(name = "Hello World")
    @Recurring(id = "hello-world-job", cron = "*/1 * * * *")
    public void doJob() {
        JOBRUNNR_LOGGER.info("Hello World!");
    }
}
