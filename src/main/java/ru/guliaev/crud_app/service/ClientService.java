package ru.guliaev.crud_app.service;

import org.springframework.stereotype.Service;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;

import java.util.List;

public interface ClientService {

     void createClient(Client client);

    Client getClientById(Long id);

    List<Client> getAllClients();

    Client update(Client client);

    void deleteById(Long id);

}
