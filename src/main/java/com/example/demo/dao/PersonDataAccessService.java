package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

// @Component also works
@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao {
	
	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPerson() {
		return DB;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personInDb = selectPersonById(id);
		if(personInDb.isEmpty()) {
			return 0;
		}
		DB.remove(personInDb.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person newPerson) {
		return selectPersonById(id)
		.map(oldPerson -> {
			int indexOfPersonToUpdate = DB.indexOf(oldPerson);
			if(indexOfPersonToUpdate >=0) {
				DB.set(indexOfPersonToUpdate, new Person(id, newPerson.getName()));
				return 1;
			}
			return 0;
		})
		.orElse(0);
	}

	@Override
	public String getPersonName(UUID id) {
		Optional<Person> personInDb = selectPersonById(id);
		if(!personInDb.isPresent()) {
			return "Person not in database";
		}
		return personInDb.get().getName();
	}

	

}
