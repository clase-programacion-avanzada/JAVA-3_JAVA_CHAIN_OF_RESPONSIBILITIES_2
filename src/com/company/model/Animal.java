package com.company.model;

import java.time.LocalDate;
import java.util.List;

public class Animal {
		
	private String name;
	private int age;
	private List<LocalDate> vaccineDates;
	
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
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
