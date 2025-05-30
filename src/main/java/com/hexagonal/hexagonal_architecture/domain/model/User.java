package com.hexagonal.hexagonal_architecture.domain.model;

import java.util.UUID;

public class User {
	private UUID id;
    private String name;
    private String email;
    
    public User() {}
    
    public User(UUID id, String name, String email) {
    	this.id = id;
    	this.name = name;
    	this.email = email;
    }
    
    
    public UUID getId() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
}
