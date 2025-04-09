package com.company.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Animal {

	private UUID id;
	private String name;
	private int age;
	private List<AppliedVaccine> appliedVaccines;
	
	
	public Animal() {
		
		this("NoName", 0);
		/*
		this.name = "NoName";
		this.age = 0;
		*/
	}
	
	public Animal(String name, int age) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.age = age;
		this.appliedVaccines =
				new ArrayList<AppliedVaccine>();
	}


	public UUID getId() {
		return id;
	}

	/**
	 * @return the vaccineDates
	 */
	public List<AppliedVaccine> getAppliedVaccines() {
		//Alternative
		//return new ArrayList<>(vaccines);
		return appliedVaccines;
	}

	//We won't have a setter for the entire list of vaccines

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	

	@Override
	public String toString() {
		//Java 21 String templates https://www.baeldung.com/java-21-string-templates
		return String.format(
			"Animal: %s | Age: %d | Vaccines: %s",
			this.name,
			this.age,
			this.appliedVaccines
		);
	}

	public String toIdAndName() {
		return String.format(
			"Animal: %s | Id: %s",
			this.name,
			this.id
		);
	}


	public boolean applyVaccine(Vaccine vaccine) {
		AppliedVaccine appliedVaccine = new AppliedVaccine(vaccine);
		return this.appliedVaccines.add(appliedVaccine);
	}

	public boolean deleteVaccine(UUID vaccineUUID) {
		for (AppliedVaccine appliedVaccine : this.appliedVaccines) {
			if (appliedVaccine.getVaccine().getId().equals(vaccineUUID)) {
				return this.appliedVaccines.remove(appliedVaccine);
			}
		}
		return false;
	}
}
