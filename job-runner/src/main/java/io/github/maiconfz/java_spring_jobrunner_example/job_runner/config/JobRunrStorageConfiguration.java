package io.github.maiconfz.java_spring_jobrunner_example.job_runner.config;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tinylog.Logger;

@Configuration
@ComponentScan(basePackageClasses = JobRunrStorageConfiguration.class)
public class JobRunrStorageConfiguration {

    private final String serverName;
    private final int port;
    private final String dbName;
    private final String user;
    private final String password;

    public JobRunrStorageConfiguration(@Value("${jobrunr.db.serverName}") String serverName,
            @Value("${jobrunr.db.port}") int port, @Value("${jobrunr.db.dbName}") String dbName,
            @Value("${jobrunr.db.user}") String user, @Value("${jobrunr.db.password}") String password) {
        this.serverName = serverName;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    @Bean(name = { "jobrunrDataSource" })
    public PGSimpleDataSource dataSource() {
        final PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerNames(new String[] { this.serverName });
        ds.setPortNumbers(new int[] { this.port });
        ds.setDatabaseName(this.dbName);
        ds.setUser(this.user);
        ds.setPassword(this.password);

        Logger.debug("jobrunrDataSource bean: {}", ReflectionToStringBuilder.toStringExclude(this, "password"));
        return ds;
    }

}
