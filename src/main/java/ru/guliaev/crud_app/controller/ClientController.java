package ru.guliaev.crud_app.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.controller.dto.UpdateClientRequest;
import ru.guliaev.crud_app.service.imp.ClientServiceImp;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientController {

    private final ClientServiceImp clientServiceImp;

    /**
     * Создание нового клиента
     *
     * @param clientDto Персольные данные клиента
     * @return статус
     */
    @PostMapping("/create")
    public StatusResponse create(@Valid @RequestBody ClientDto clientDto) {
        log.info("[API] create new client {}", clientDto.getSurname());
        return clientServiceImp.createClient(clientDto);
    }

    /**
     * Поиск клиента по id
     *
     * @param id клиента
     * @return clientDto
     */
    @GetMapping("/find/{id}")
    public ClientDto findById(@NotBlank @PathVariable Long id) {
        log.info("[API] find client with id = {}", id);
        return clientServiceImp.getClientById(id);
    }

    /**
     * Получение списка всех клиенов
     *
     * @return список
     */
    @GetMapping("/findAll")
    public List<ClientDto> findAll() {
        log.info("[API] find all clients");
        return clientServiceImp.getAllClients();
    }

    /**
     * Обновление данных существующих клиентов
     *
     * @param updateClientRequest запрос на обновление
     * @return статус
     */
    @PostMapping("/update")
    public StatusResponse update(@Valid @RequestBody UpdateClientRequest updateClientRequest) {
        log.info("[API] update client {}", updateClientRequest.getClientDto().getSurname());
        return clientServiceImp.update(updateClientRequest);
    }

    /**
     * Удаление клиента
     *
     * @param id клиента
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@NotBlank @PathVariable Long id) {
        log.info("[API] delete client with id = {}", id);
        return clientServiceImp.deleteById(id);
    }

    /**
     * Удаление всех клиентов
     *
     * @return статус
     */
    @DeleteMapping("/deleteAll")
    public StatusResponse deleteAll() {
        log.info("[API] delete all clients");
        return clientServiceImp.deleteAll();
    }
}
