package com.example.batch.batch.infrastructure.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ClientJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(@NonNull JobExecution jobExecution) {
        System.out.println("Before executing Job!!!");
    }

    @Override
    public void afterJob(@NonNull JobExecution jobExecution) {
        System.out.println("After executing Job!!!");
    }
}
