package com.hexagonal.hexagonal_architecture.application.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hexagonal.hexagonal_architecture.domain.model.User;

public interface UserRepositoryPort {
	User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAll();
    void deleteById(UUID id);
}
