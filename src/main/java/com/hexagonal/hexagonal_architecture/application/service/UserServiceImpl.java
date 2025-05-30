package com.hexagonal.hexagonal_architecture.application.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hexagonal.hexagonal_architecture.application.dto.UserDto;
import com.hexagonal.hexagonal_architecture.application.dto.UserResponseDto;
import com.hexagonal.hexagonal_architecture.application.ports.in.UserServicePort;
import com.hexagonal.hexagonal_architecture.application.ports.out.UserRepositoryPort;
import com.hexagonal.hexagonal_architecture.domain.model.User;

@Service
public class UserServiceImpl implements UserServicePort {
	
	private final UserRepositoryPort userRepository;
	
	public UserServiceImpl(UserRepositoryPort userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponseDto create(UserDto userDto) {
		User user = new User(UUID.randomUUID(), userDto.name(), userDto.email());
		return toResponse(userRepository.save(user));
	}

	@Override
	public UserResponseDto getById(UUID id) {
		return userRepository.findById(id)
				.map(this::toResponse)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public List<UserResponseDto> getAll() {
		return userRepository.findAll()
				.stream()
				.map(this::toResponse)
				.collect(Collectors.toList());
	}

	@Override
	public UserResponseDto update(UUID id, UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}
	
	private UserResponseDto toResponse(User user) {
		return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
	}

}
