package ru.guliaev.crud_app.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.entity.Client;

import java.util.List;
import java.util.stream.StreamSupport;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDtoMapper {

    public static Client toEntity(ClientDto clientDto) {
        return Client.builder()
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .birthday(clientDto.getBirthday())
                .phoneNumber(clientDto.getPhoneNumber())
                .build();
    }

    public static ClientDto toDto(Client client) {
        return ClientDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .birthday(client.getBirthday())
                .phoneNumber(client.getPhoneNumber())
                .nameOfRole(client.getRole().getNameOfRole())
                .build();
    }

    public static List<ClientDto> toDtoList(Iterable<Client> clients) {
        return StreamSupport.stream(clients.spliterator(), false)
                .map(ClientDtoMapper::toDto)
                .toList();
    }

    public static void fillIn(Client client, ClientDto clientDto) {
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
    }
}