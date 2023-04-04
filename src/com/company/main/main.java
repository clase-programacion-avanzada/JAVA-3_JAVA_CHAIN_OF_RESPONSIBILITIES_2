package com.company.main;

import java.util.ArrayList;
import java.util.List;

import com.company.model.Animal;

public class Main {

	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<Animal>();
		
		Animal dog = new Animal("Paco", 3);
		
		animals.add(dog);
		
		Animal cat = new Animal("Amelia", 4);
		
		animals.add(cat);
		
		dog.setName("Fabricio");
		
		System.out.println(dog.getName());
	}
}
