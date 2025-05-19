package com.example.batch.batch.infrastructure.component;

import com.example.batch.batch.domain.model.Client;
import com.example.batch.batch.domain.model.ClientProcessed;
import com.example.batch.batch.domain.service.ClientService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClientProcessor implements ItemProcessor<Client, ClientProcessed> {
    private final ClientService clientService;

    public ClientProcessor(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientProcessed process(Client client) {
        System.out.println("In Processing!!");
        return clientService.processClient(client);
    }
}
