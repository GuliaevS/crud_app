package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.RoleRequest;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Client;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.repository.ClientRepository;
import ru.guliaev.crud_app.repository.RoleRepository;
import ru.guliaev.crud_app.service.RoleService;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;
    private final ClientRepository clientRepository;

    @Override
    public StatusResponse create(Role role) {
        roleRepository.save(role);
        return new StatusResponse("Роль успешно создана");
    }

    @Override
    @Transactional
    public StatusResponse set(RoleRequest roleRequest) {
        Client client = clientRepository.findById(roleRequest.getClient().getId()).orElse(null);
        Role role = roleRepository.findById(roleRequest.getRole_id()).orElse(null);

        return new StatusResponse("Роль успешно установлена");

    }
}
