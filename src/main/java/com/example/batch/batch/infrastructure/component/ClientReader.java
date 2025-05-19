package com.example.batch.batch.infrastructure.component;

import com.example.batch.batch.domain.model.Client;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientReader {
    private final EntityManagerFactory emf;

    public ClientReader(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Bean
    public JpaPagingItemReader<Client> reader() {
        System.out.println("In reading");
        return new JpaPagingItemReaderBuilder<Client>()
                .name("clientReader")
                .entityManagerFactory(emf)
                .queryString("SELECT c FROM Client c")
                .pageSize(5)
                .build();
    }
}
