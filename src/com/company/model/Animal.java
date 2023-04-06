package com.company.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Animal {
		
	private String name;
	private int age;
	private List<Vaccine> vaccines;
	
	
	public Animal() {
		
		this("NoName", 0);
		/*
		this.name = "NoName";
		this.age = 0;
		*/
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		this.vaccines = 
				new ArrayList<Vaccine>();
	}
	
	
	
	/**
	 * @return the vaccineDates
	 */
	public List<Vaccine> getVaccinees() {
		return vaccines;
	}

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
	
	public void addVaccine(
			LocalDate dateOfVaccine, 
			int volume,
			String brand) {
		
		Vaccine vaccine = 
				new Vaccine(
					dateOfVaccine,
					volume,
					brand);
		
		this.vaccines.add(vaccine);
		
	}
	
	public void addVaccine( 
			int volume,
			String brand) {
		 
		Vaccine vaccine = 
				new Vaccine(volume,brand);		
		
		this.vaccines.add(vaccine);
		
	}
	
	public boolean removeVaccine( 
			int index) {
		 
			
		return this.vaccines.remove(index) 
				!= null;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
