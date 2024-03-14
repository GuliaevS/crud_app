package ru.guliaev.crud_app.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.entity.Client;

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
}

