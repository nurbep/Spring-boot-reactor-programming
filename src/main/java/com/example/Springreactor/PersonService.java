package com.example.Springreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
	
	Mono<Person> getPerson(String firstName);
	Flux<Person> getPersons();

}
