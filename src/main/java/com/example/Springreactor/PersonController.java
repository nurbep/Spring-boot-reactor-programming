package com.example.Springreactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/person/{firstName}")
	public Mono<Person> getPerson(@PathVariable("firstName") String firstName)
	{
		return personService.getPerson(firstName);
	}
	
	@GetMapping("/persons")
	public Flux<Person> getPersons()
	{
		return personService.getPersons();
	}

}
