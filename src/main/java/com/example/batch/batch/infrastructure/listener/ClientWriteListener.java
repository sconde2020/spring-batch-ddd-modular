package com.example.batch.batch.infrastructure.listener;

import com.example.batch.batch.domain.model.ClientProcessed;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientWriteListener implements ItemWriteListener<ClientProcessed> {

    @Override
    public void beforeWrite(List<? extends ClientProcessed> items) {
        System.out.println("Before writing: " + items.size() + " items");
    }

    @Override
    public void afterWrite(List<? extends ClientProcessed> items) {
        System.out.println("After writing: " + items.size() + " items");
    }

    @Override
    public void onWriteError(Exception e, List<? extends ClientProcessed> items) {
        System.out.println("Error writing: " + e.getMessage());
    }
}
