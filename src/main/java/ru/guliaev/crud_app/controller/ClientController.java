package ru.guliaev.crud_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;
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
     * @param client Персольные данные клиента
     * @return статус
     */
    @PostMapping("/create")
    public StatusResponse create(@RequestBody Client client) {
        clientServiceImp.createClient(client);
        return new StatusResponse("Данные успешно записаны");
    }

    /**
     * Поиск клиента по id
     * @param id
     * @return клиент
     */
    @GetMapping("/find/{id}")
    public Client findById(@PathVariable Long id) {
        return clientServiceImp.getClientById(id);
    }

    /**
     * Получение списка всех клиенов
     * @return список
     */
    @GetMapping("/findAll")
    public List<Client> findAll() {
        return clientServiceImp.getAllClients();
    }

    /**
     * Обновление данных существующих клиентов
     * @param client  Изменяемый клиент
     * @return клиент
     */
    @PostMapping ("/update")
    public Client update(@RequestBody Client client) {
        return clientServiceImp.update(client);
    }

    /**
     * Удаление клиента
     * @param id
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@PathVariable Long id) {
        clientServiceImp.deleteById(id);
        return new StatusResponse("Данные успешно удалены");
    }


}
