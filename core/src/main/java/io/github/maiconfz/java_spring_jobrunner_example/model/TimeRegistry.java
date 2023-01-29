package io.github.maiconfz.java_spring_jobrunner_example.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TimeRegistry {
    private final Long id;
    private final LocalDateTime dateTime;
}
