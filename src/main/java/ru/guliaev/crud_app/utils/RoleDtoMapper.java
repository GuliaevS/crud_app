package ru.guliaev.crud_app.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.guliaev.crud_app.controller.dto.RoleDto;
import ru.guliaev.crud_app.entity.Role;

import java.util.List;
import java.util.stream.StreamSupport;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDtoMapper {

    public static Role toEntity(RoleDto roleDto) {
        return Role.builder()
                .nameOfRole(roleDto.getNameOfRole())
                .build();
    }

    public static RoleDto toDto(Role role) {
        return RoleDto.builder()
                .nameOfRole(role.getNameOfRole())
                .build();
    }

    public static List<RoleDto> toDtoList(Iterable<Role> roles) {
        return StreamSupport.stream(roles.spliterator(), false)
                .map(RoleDtoMapper::toDto)
                .toList();
    }
}
