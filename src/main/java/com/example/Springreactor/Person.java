package com.example.Springreactor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private double monthlyIncome;
	
	public Person() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Person(Long id, String firstName, String lastName, double monthlyIncome) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthlyIncome = monthlyIncome;
	}
	
	
}
