package ru.guliaev.crud_app.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.controller.dto.StatusResponse;
import ru.guliaev.crud_app.entity.Role;
import ru.guliaev.crud_app.exception.IdException;
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
        Role savedRole = RoleDtoMapper.toEntity(roleDto);
        roleRepository.save(savedRole);
        return RoleDtoMapper.toDto(savedRole);
    }

    @Override
    @Transactional
    public List<RoleDto> getAllRoles() {
        Iterable<Role> allRoles = roleRepository.findAll();
        return RoleDtoMapper.toDtoList(allRoles);
    }

    @Override
    @Transactional
    public RoleDto update(RoleDto roleDto, Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()
                        -> new IdException("Id %d of role is not found".formatted(id)));

        role.setNameOfRole(roleDto.getNameOfRole());
        roleRepository.save(role);
        return RoleDtoMapper.toDto(role);
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
