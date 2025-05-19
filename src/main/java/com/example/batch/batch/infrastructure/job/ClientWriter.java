package com.example.batch.batch.infrastructure.job;

import com.example.batch.batch.domain.model.ClientProcessed;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientWriter {
    private final EntityManagerFactory emf;

    public ClientWriter(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Bean
    public JpaItemWriter<ClientProcessed> writer() {
        JpaItemWriter<ClientProcessed> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }
}
