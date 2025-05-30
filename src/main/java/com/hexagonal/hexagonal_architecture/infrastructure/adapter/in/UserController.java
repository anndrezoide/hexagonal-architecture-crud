package com.hexagonal.hexagonal_architecture.infrastructure.adapter.in;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.hexagonal_architecture.application.dto.UserDto;
import com.hexagonal.hexagonal_architecture.application.dto.UserResponseDto;
import com.hexagonal.hexagonal_architecture.application.ports.in.UserServicePort;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserServicePort userService;
	
	public UserController(UserServicePort userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public UserResponseDto create(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}
	
	@GetMapping("/{id}")
	public UserResponseDto getById(@PathVariable UUID id) {
		return userService.getById(id);
	}
	
	@GetMapping
	public List<UserResponseDto> getAll(){
		return userService.getAll();
	}
	
	@PutMapping("/{id}")
	public UserResponseDto update(@PathVariable UUID id, @RequestBody UserDto userDto) {
		return userService.update(id, userDto);
	}
	
	@DeleteMapping
	public void delete(@PathVariable UUID id) {
		userService.delete(id);
	}

}
