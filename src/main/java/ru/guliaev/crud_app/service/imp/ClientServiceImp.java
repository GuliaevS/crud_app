package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.repository.ClientRepository;
import ru.guliaev.crud_app.repository.RoleRepository;
import ru.guliaev.crud_app.service.ClientService;
import ru.guliaev.crud_app.utils.ClientDtoMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public ClientDto createClient(ClientDto clientDto) {
        Optional<Role> roleOptional = roleRepository.findByNameOfRole(clientDto.getNameOfRole());
        if (roleOptional.isEmpty()) {
            log.error("Роль не найдена в репозитории");
        }
        Role role = roleOptional.get(); // дописать исключение
        Client client = ClientDtoMapper.toEntity(clientDto);
        client.setRole(role);
        Client savedClient = clientRepository.save(client);
        return ClientDtoMapper.toDto(savedClient);
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow();
        return ClientDtoMapper.toDto(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> allClients = (List<Client>) clientRepository.findAll();
        return allClients.stream()
                .map(ClientDtoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto clientDto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow();
        if (clientDto.getName() != null) {
            client.setName(clientDto.getName());
        }
        if (clientDto.getSurname() != null) {
            client.setSurname(clientDto.getSurname());
        }
        if (clientDto.getBirthday() != null) {
            client.setBirthday(clientDto.getBirthday());
        }
        if (clientDto.getPhoneNumber() != null) {
            client.setPhoneNumber(clientDto.getPhoneNumber());
        }

        String nameOfRole = clientDto.getNameOfRole();
        if (nameOfRole != null) {
            Optional<Role> roleOptional = roleRepository.findByNameOfRole(nameOfRole);
            if (roleOptional.isEmpty()) {
                log.error("Роль не найдена в репозитории");
            }
            Role role = roleOptional.get();
            client.setRole(role);
        }

        clientRepository.save(client);
        return ClientDtoMapper.toDto(client);
    }

    @Override
    @Transactional
    public StatusResponse deleteById(Long id) {
        clientRepository.deleteById(id);
        return new StatusResponse("Данные клиента успешно удалены");
    }

    @Override
    @Transactional
    public StatusResponse deleteAll() {
        clientRepository.deleteAll();
        return new StatusResponse("Данные всех клиентов успешно удалены");
    }
}
