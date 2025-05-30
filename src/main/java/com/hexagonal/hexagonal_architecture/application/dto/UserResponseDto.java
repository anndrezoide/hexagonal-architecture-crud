package com.hexagonal.hexagonal_architecture.application.dto;

import java.util.UUID;

public record UserResponseDto(UUID id, String name, String email) {}
