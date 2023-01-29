package io.github.maiconfz.java_spring_jobrunner_example.job_runner.job.impl;

import org.jobrunr.jobs.context.JobRunrDashboardLogger;
import org.jobrunr.spring.annotations.Recurring;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tinylog.Logger;

import io.github.maiconfz.java_spring_jobrunner_example.job_runner.job.Job;

@Component
public class SimpleJob implements Job {
    private static final org.slf4j.Logger JOBRUNNR_LOGGER = new JobRunrDashboardLogger(LoggerFactory.getLogger(SimpleJob.class));

    @Override
    @org.jobrunr.jobs.annotations.Job(name = "Simple Job")
    @Recurring(id = "simple-job", cron = "*/1 * * * *")
    public void doJob() {
        Logger.info("SimpleJob...");
        JOBRUNNR_LOGGER.info("SimpleJob");
    }
}
