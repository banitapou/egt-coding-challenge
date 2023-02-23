package com.egt.challenge.service;

import java.util.List;
import java.util.Optional;

import com.egt.challenge.model.Person;

import lombok.Data;
@Data

public interface PersonService {

	List<Person> all();

	Optional<Person> find(long id);

	Person addPerson(Person newPerson);
}
