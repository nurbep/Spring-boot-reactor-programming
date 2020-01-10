package com.example.Springreactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;
	
	@Override
	public Mono<Person> getPerson(String firstName) {
		
		/*
		 * Mono<Person> person = Mono .defer(() ->
		 * Mono.just(this.personRepository.findByFirstName(firstName)))
		 * .subscribeOn(jdbcScheduler);
		 */
		
		
		  Mono<Person> person = Mono.fromCallable(() ->
		  this.personRepository.findByFirstName(firstName))
		  .subscribeOn(jdbcScheduler);
		 
		
		return person;
		
	}
	
@Override
public Flux<Person> getPersons( ) {
		
		/*
		 * Mono<Person> person = Mono .defer(() ->
		 * Mono.just(this.personRepository.findByFirstName(firstName)))
		 * .subscribeOn(jdbcScheduler);
		 */
		
		
	Flux<Person> persons = Flux.defer(() -> Flux.fromIterable(this.personRepository.findAll()))
	          .subscribeOn(jdbcScheduler);
		
		return persons;
		
	}

}
