package ru.guliaev.crud_app.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guliaev.crud_app.controller.dto.ClientDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
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
    @PostMapping("/create") // для всех
    public StatusResponse create(@RequestBody ClientDto clientDto) {
        return clientServiceImp.createClient(clientDto);
    }

    /**
     * Поиск клиента по id
     *
     * @param id
     * @return clientDto
     */
    @GetMapping("/find/{id}")
    public ClientDto findById(@NotBlank @PathVariable Long id) {
        return clientServiceImp.getClientById(id);
    }

    /**
     * Получение списка всех клиенов
     *
     * @return список
     */
    @GetMapping("/findAll") //для всех
    public List<ClientDto> findAll() {
        return clientServiceImp.getAllClients();
    }

    /**
     * Обновление данных существующих клиентов
     *
     * @param id Изменяемый клиент
     * @return клиент
     */
    @PostMapping("/update")
    public ClientDto update(@RequestParam Long id) {
        return clientServiceImp.update(id);
    }

    /**
     * Удаление клиента
     *
     * @param id
     * @return статус
     */
    @DeleteMapping("/delete/{id}")
    public StatusResponse delete(@PathVariable Long id) {
        return clientServiceImp.deleteById(id);
    }

    /**
     * Удаление всех клиентов
     *
     * @return статус
     */
    @DeleteMapping("/deleteAll")
    public StatusResponse deleteAll() {
        return clientServiceImp.deleteAll();
    }
}
