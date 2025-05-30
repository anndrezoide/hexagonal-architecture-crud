package com.hexagonal.hexagonal_architecture.infrastructure.adapter.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.hexagonal.hexagonal_architecture.application.ports.out.UserRepositoryPort;
import com.hexagonal.hexagonal_architecture.domain.model.User;
import com.hexagonal.hexagonal_architecture.infrastructure.persistence.entity.UserEntity;
import com.hexagonal.hexagonal_architecture.infrastructure.persistence.repository.UserJpaRepository;

public class UserJpaRepositoryAdapter implements UserRepositoryPort{
	
	private final UserJpaRepository repository;
	
	public UserJpaRepositoryAdapter(UserJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public User save(User user) {
		return toDomain(repository.save(toEntity(user)));
	}

	@Override
	public Optional<User> findById(UUID id) {
		return repository.findById(id)
				.map(this::toDomain);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll()
				.stream()
				.map(this::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
	
	private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        return entity;
    }
	
	private User toDomain(UserEntity entity) {
		return new User(entity.getId(), entity.getName(), entity.getEmail());
	}
}
