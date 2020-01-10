package com.example.Springreactor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

	  Person findByFirstName(String firstName);
	
}
