package com.egt.challenge.service;

import com.egt.challenge.model.Person;
import com.egt.challenge.repo.PersonRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    @NonNull
    private final PersonRepository personRepository;
    
    public PersonServiceImpl(PersonRepository repo) {
    	this.personRepository = repo;
    }
    
    public List<Person> all() {
    	return personRepository.findAll();
    }
    
    public Optional<Person> find(long id) {
    	return Optional.of(personRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Person")));
    }
    
    public Person addPerson(Person person) {
    	return personRepository.save(person);
    }
    
    public Person updatePerson(Person person, long id) {
    	 return personRepository.findById(id)
    		.map(p -> {
    			p.setFirstName(person.getFirstName());
    			p.setLastName(person.getLastName());
    			p.setBirthDate(person.getBirthDate());
    			p.setMainAddress(person.getMainAddress());
    			p.setAdditionalAddresses(person.getAdditionalAddresses());
    			return p;
    		}).orElseGet(() -> {
    			return personRepository.save(person);
    		});
    }
    
    public void deletePerson(Person person) {
    	personRepository.delete(person);
    }
}
