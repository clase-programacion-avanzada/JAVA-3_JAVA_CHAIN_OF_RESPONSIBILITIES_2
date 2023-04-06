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
		
		Animal nonAdoptedAnimal = new Animal();
		
		animals.add(nonAdoptedAnimal);
		
		nonAdoptedAnimal.setName("Pancracio");
		nonAdoptedAnimal.setAge(1);
		
			
		for(int i = 0 ; i < animals.size() ; i++) {
			Animal auxAnimal = animals.get(i);
			System.out.println(
					auxAnimal.getName() + 
					" " + 
					auxAnimal.getAge());
		}
		
		for(Animal auxAnimal : animals) {
			System.out.println(
					auxAnimal.getName() + 
					" " + 
					auxAnimal.getAge());
		}
		
		animals.remove(2);
		
		for(Animal auxAnimal : animals) {
			System.out.println(
					auxAnimal.getName() + 
					" " + 
					auxAnimal.getAge());
		}
		

		
	}
}
