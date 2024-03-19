package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.exception.IdException;
import ru.guliaev.crud_app.exception.RoleNotFoundException;
import ru.guliaev.crud_app.repository.ClientRepository;
import ru.guliaev.crud_app.repository.RoleRepository;
import ru.guliaev.crud_app.service.ClientService;
import ru.guliaev.crud_app.utils.ClientDtoMapper;

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
    public ClientDto create(ClientDto clientDto) {
        Optional<Role> roleOptional = roleRepository.findByNameOfRole(clientDto.getNameOfRole());
        if (roleOptional.isEmpty()) {
            throw new RoleNotFoundException("Role not found in repository");
        }

        Role role = roleOptional.get();
        Client client = ClientDtoMapper.toEntity(clientDto);
        client.setRole(role);
        clientRepository.save(client);
        return ClientDtoMapper.toDto(client);
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()
                        -> new IdException("Id %d of client is not found".formatted(id)));

        return ClientDtoMapper.toDto(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        Iterable<Client> allClients = clientRepository.findAll();
        return ClientDtoMapper.toDtoList(allClients);
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto clientDto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()
                        -> new IdException("Id %d of client is not found".formatted(id)));

        ClientDtoMapper.fillIn(client, clientDto);

        if (clientDto.getNameOfRole() != null) {
            Optional<Role> roleOptional = roleRepository.findByNameOfRole(clientDto.getNameOfRole());
            if (roleOptional.isEmpty()) {
                throw new RoleNotFoundException("Role not found in repository");
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
