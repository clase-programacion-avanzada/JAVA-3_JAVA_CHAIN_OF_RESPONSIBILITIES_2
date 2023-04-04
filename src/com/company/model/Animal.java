package com.company.model;

public class Animal {
		
	private String name;
	private int age;
	
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
	
	
}
