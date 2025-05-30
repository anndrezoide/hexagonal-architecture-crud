package com.hexagonal.hexagonal_architecture.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.hexagonal_architecture.domain.model.User;
import com.hexagonal.hexagonal_architecture.infrastructure.persistence.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID>{}