package com.hexagonal.hexagonal_architecture.application.ports.in;

import java.util.List;
import java.util.UUID;

import com.hexagonal.hexagonal_architecture.application.dto.UserDto;
import com.hexagonal.hexagonal_architecture.application.dto.UserResponseDto;

public interface UserServicePort {
	UserResponseDto create(UserDto userDto);
    UserResponseDto getById(UUID id);
    List<UserResponseDto> getAll();
    UserResponseDto update(UUID id, UserDto userDto);
    void delete(UUID id);
}
