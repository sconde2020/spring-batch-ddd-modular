package com.example.batch.batch.infrastructure.listener;

import com.example.batch.batch.domain.model.Client;
import com.example.batch.batch.domain.model.ClientProcessed;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class ClientProcessListener implements ItemProcessListener<Client, ClientProcessed> {

    @Override
    public void beforeProcess(Client item) {
        System.out.println("Before processing: " + item.getNom());
    }

    @Override
    public void afterProcess(Client item, ClientProcessed result) {
        System.out.println("After processing: " + result.getNom());
    }

    @Override
    public void onProcessError(Client item, Exception e) {
        System.out.println("Error processing: " + item.getNom() + " - " + e.getMessage());
    }
}
