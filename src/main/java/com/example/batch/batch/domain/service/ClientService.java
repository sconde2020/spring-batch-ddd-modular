package com.example.batch.batch.domain.service;

import com.example.batch.batch.domain.model.Client;
import com.example.batch.batch.domain.model.ClientProcessed;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    public ClientProcessed processClient(Client client) {
        ClientProcessed processed = new ClientProcessed();
        processed.setId(client.getId());
        processed.setNom(client.getNom().toUpperCase());
        processed.setEmail(client.getEmail());
        return processed;
    }
}
