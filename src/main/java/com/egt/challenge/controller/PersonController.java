package com.egt.challenge.controller;

//import com.egt.challenge.dto.PersonMapper;
import com.egt.challenge.repo.PersonRepository;
import com.egt.challenge.service.PersonService;
import com.egt.challenge.service.PersonServiceImpl;

//import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import com.egt.challenge.model.Person;

@RestController
@RequestMapping(PersonController.BASE_URL)
@RequiredArgsConstructor
public class PersonController {
    public static final String BASE_URL = "/api/persons";

    private final PersonService personService;

    PersonController(PersonRepository repository) {
      this.personService = new PersonServiceImpl(repository);
    }

    @GetMapping("/persons")
    List<Person> all(){
    	return this.personService.all();
    }
    
    @GetMapping("/person/{id}")
    Person getPerson(long id) {
    	Optional<Person> person =  this.personService.find(id);
    	
    	if(person != null) {
    		return person.get();
    	} else {
    		return new Person();
    	}
    }
    @PostMapping("/persons")
    Person save(Person newPerson){
    	return this.personService.addPerson(newPerson);
    }
    @DeleteMapping("/persons/{id}")
    void deletePerson(long id) {
    }
}
