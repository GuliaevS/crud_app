package ru.guliaev.crud_app.service;

import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;

import java.util.List;

public interface ClientService {

    StatusResponse createClient(ClientDto clientDto);

    ClientDto getClientById(Long id);

    List<ClientDto> getAllClients();

    ClientDto update(Long id);

    StatusResponse deleteById(Long id);

    StatusResponse deleteAll();

}
