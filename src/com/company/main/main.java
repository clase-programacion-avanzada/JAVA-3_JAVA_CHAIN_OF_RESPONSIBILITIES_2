package com.company.main;

import com.company.model.Animal;

public class Main {

	public static void main(String[] args) {
		
		Animal dog = new Animal("Paco", 3);
		
		dog.setName("Fabricio");
		
		System.out.println(dog.getName());
	}
}
