package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.repository.RoleRepository;
import ru.guliaev.crud_app.service.RoleService;
import ru.guliaev.crud_app.utils.RoleDtoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public RoleDto create(RoleDto roleDto) {
        roleRepository.save(RoleDtoMapper.toEntity(roleDto));
        return roleDto;
    }

    @Override
    @Transactional
    public List<RoleDto> getAllRoles() {
        List <Role> allRoles = (List<Role>) roleRepository.findAll();
        return allRoles.stream()
                .map(RoleDtoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public RoleDto update(RoleDto roleDto, Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow();
        role.setNameOfRole(roleDto.getNameOfRole());
        roleRepository.save(role);
        return roleDto;
    }

    @Override
    @Transactional
    public StatusResponse delete(Long id) {
        roleRepository.deleteById(id);
        return new StatusResponse("Роль успешно удалена");
    }

    @Override
    @Transactional
    public StatusResponse deleteAll() {
        roleRepository.deleteAll();
        return new StatusResponse("Все роли успешно удалены");
    }
}
