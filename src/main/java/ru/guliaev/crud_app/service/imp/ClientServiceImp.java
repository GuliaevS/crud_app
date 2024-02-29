package ru.guliaev.crud_app.service.imp;

import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.repository.ClientRepository;
import ru.guliaev.crud_app.service.ClientService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public StatusResponse createClient(Client client) {
        clientRepository.save(client);
        return new StatusResponse("Данные успешно записаны");
    }

    @Override
    @Transactional
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client update(Client client) {
        Client updateClient = clientRepository.findById(client.getId())
                .orElse(null);
        updateClient.setName(client.getName());
        updateClient.setSurname(client.getSurname());
        updateClient.setBirthday(client.getBirthday());
        updateClient.setPhoneNumber(client.getPhoneNumber());
        return clientRepository.save(updateClient);
    }

    @Override
    @Transactional
    public StatusResponse deleteById(Long id) {
        clientRepository.deleteById(id);
        return new StatusResponse("Данные успешно удалены");
    }

    public BigDecimal calculate(BigDecimal one, BigDecimal two, String command) {
        if ("multiply".equals(command)) {
            return one.multiply(two);
        }
        if ("divide".equals(command)) {
            return one.divide(two, RoundingMode.HALF_UP);
        }
        if ("add".equals(command)) {
            return one.add(two);
        }
        if ("max".equals(command)) {
            return one.max(two);
        }
        throw new RuntimeException("Command %s is not supported".formatted(command));
    }

    public Client createNewClient(String name, String surname) {
        Client client = new Client();
        client.setId(1);
        client.setName(name);
        client.setSurname(surname);
        return client;
    }
}
