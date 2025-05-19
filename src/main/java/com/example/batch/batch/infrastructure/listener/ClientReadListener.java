package com.example.batch.batch.infrastructure.listener;

import com.example.batch.batch.domain.model.Client;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class ClientReadListener implements ItemReadListener<Client> {
    @Override
    public void beforeRead() {
        System.out.println("Before reading...");
    }

    @Override
    public void afterRead(Client item) {
        System.out.println("Read: " + item.getNom());
    }

    @Override
    public void onReadError(Exception ex) {
        System.out.println("Error reading: " + ex.getMessage());
    }
}
