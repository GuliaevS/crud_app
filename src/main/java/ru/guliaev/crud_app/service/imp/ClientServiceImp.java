package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.controller.dto.UpdateClientRequest;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.repository.ClientRepository;
import ru.guliaev.crud_app.service.ClientService;
import ru.guliaev.crud_app.utils.ClientDtoMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public StatusResponse createClient(ClientDto clientDto) {
        Client entity = ClientDtoMapper.toEntity(clientDto);
        clientRepository.save(entity);

        //todo При создании пользователя указывать его роль текстом
        //
        //{
        //"name": "Andrew",
        //"surname": "Bessonov",
        //"role": "admin"
        //}
        return new StatusResponse("Данные успешно записаны");
    }

    @Override
    @Transactional
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow();
        return ClientDtoMapper.toDto(client);
    }

    @Override
    @Transactional
    public List<ClientDto> getAllClients() {
        List<Client> allClients = (List<Client>) clientRepository.findAll();
        return allClients.stream()
                .map(ClientDtoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public StatusResponse update(UpdateClientRequest updateClientRequest) {
        Client client = clientRepository.findById(updateClientRequest.getId())
                .orElseThrow();
        ClientDto clientDto = updateClientRequest.getClientDto();
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setBirthday(clientDto.getBirthday());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        return new StatusResponse("Даннные клиента успешно обновлены");
    }

    @Override
    @Transactional
    public StatusResponse deleteById(Long id) {
        clientRepository.deleteById(id);
        return new StatusResponse("Данные клиента успешно удалены");
    }

    @Override
    public StatusResponse deleteAll() {
        clientRepository.deleteAll();
        return new StatusResponse("Данные всех клиентов успешно удалены");
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
