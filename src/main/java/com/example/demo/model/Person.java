package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final  UUID id;
	private final String name;
	int userId;
	String lastName;
	
	UUID uuid = UUID.randomUUID();
	
	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}
	
	public Person(int userId, String name, String lastName) {
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.id = uuid;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Person [userId=" + userId +", name=" + name +   ", lastName=" + lastName + ", id"+ id + "]";
	}
	
}
