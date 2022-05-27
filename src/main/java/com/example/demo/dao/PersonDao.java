package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {

	public int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	public List<Person> selectAllPerson();
	
	Optional<Person> selectPersonById(UUID id);
	
	public int deletePersonById(UUID id);
	
	public int  updatePersonById(UUID id, Person person);
	
	public String getPersonName(UUID id);
}
