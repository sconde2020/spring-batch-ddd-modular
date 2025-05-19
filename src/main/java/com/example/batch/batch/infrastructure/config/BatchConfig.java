package com.example.batch.batch.infrastructure.config;

import com.example.batch.batch.domain.model.Client;
import com.example.batch.batch.domain.model.ClientProcessed;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager,
                     ItemReader<Client> reader,
                     ItemProcessor<Client, ClientProcessed> processor,
                     ItemWriter<ClientProcessed> writer) {
        return new StepBuilder("step", jobRepository)
                .<Client, ClientProcessed>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("demoJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public CommandLineRunner run(JobLauncher jobLauncher, Job job) {
        return args -> {
            jobLauncher.run(job, new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters());
        };
    }

}
