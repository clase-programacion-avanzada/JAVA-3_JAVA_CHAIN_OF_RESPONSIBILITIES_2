package com.company;

import com.company.controllers.AdminController;
import java.util.List;

import java.util.Scanner;
import java.util.UUID;

public class Main {

	//We need to create the controller to interact with the services
	//First alternative
	/*
	//First we need to create the services
	private static AnimalService animalService = new AnimalService();
	private static VaccineService vaccineService = new VaccineService();

	//Then we create the controller
	private static AdminController adminController =
		new AdminController(animalService, vaccineService);
	*/
	private static AdminController adminController = new AdminController();
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		String menu =
			"""
           1. Create new animal
           2. Create a new vaccine
           3. Apply vaccine to an animal
           4. Show all animals
           5. Show all vaccines
           6  Show vaccines applied to an animal
           7. Delete a vaccine
           8. Delete an animal
           9. Exit
           """;

		do {

			System.out.println(menu);
			option = scanner.nextInt();
			scanner.nextLine();

			switch(option) {
				case 1 -> createNewAnimal(scanner);
				case 2 -> createNewVaccine(scanner);
				case 3 -> applyVaccineToAnimal(scanner);
				case 4 -> showAllAnimals();
				case 5 -> showAllVaccines();
				case 6 -> showVaccinesAppliedToAnimal(scanner);
				case 7 -> deleteVaccine(scanner);
				case 8 -> deleteAnimal(scanner);
				case 9 -> System.out.println("Bye");
				default -> System.out.println("Invalid option");
			}

		} while(option != 9);
		
		scanner.close();
		
	}

	private static void deleteVaccine(Scanner scanner) {
		System.out.println("Enter the vaccine id");
		showAllVaccines();

		String vaccineNumber = scanner.nextLine();


		boolean vaccineDeleted = adminController.deleteVaccine(vaccineNumber);

		if(vaccineDeleted) {
			System.out.println("Vaccine deleted successfully");
		} else {
			System.out.println("Vaccine not deleted");
		}
	}

	private static void deleteAnimal(Scanner scanner) {
		System.out.println("Enter the animal number (not the id)");
		showAnimalNamesAndIds();

		int animalNumber = scanner.nextInt();
		scanner.nextLine();

		boolean animalDeleted = adminController.deleteAnimal(animalNumber);

		if(animalDeleted) {
			System.out.println("Animal deleted successfully");
		} else {
			System.out.println("Animal not deleted");
		}
	}

	private static void showVaccinesAppliedToAnimal(Scanner scanner) {
		System.out.println("Enter the animal number (not the id)");
		showAnimalNamesAndIds();

		int animalNumber = scanner.nextInt();
		scanner.nextLine();

		List<String> vaccinesAppliedToAnimal = adminController.getVaccinesAppliedToAnimal(animalNumber);
		for(String vaccine : vaccinesAppliedToAnimal) {
			System.out.println(vaccine);
		}

	}

	private static void showAnimalNamesAndIds() {
		List<String> animals = adminController.getAnimalIdAndNames();
		for(String animal : animals) {
			System.out.println(animal);
		}
	}

	private static void showAllVaccines() {
		System.out.println("These are all the vaccines:");
		List<String> vaccines = adminController.getVaccines();
		for(String vaccine : vaccines) {
			System.out.println(vaccine);
		}
	}

	private static void showNonExpiredVaccines() {
		System.out.println("These are all the vaccines:");
		List<String> vaccines = adminController.getNonExpiredVaccines();
		for(String vaccine : vaccines) {
			System.out.println(vaccine);
		}
	}

	private static void showAllAnimals() {
		System.out.println("These are all the animals:");
		List<String> animals = adminController.getAnimals();
		for(String animal : animals) {
			System.out.println(animal);
		}

	}

	private static void applyVaccineToAnimal(Scanner scanner) {
		System.out.println("Applying vaccine to an animal");

		showAnimalNamesAndIds();
		System.out.println("Enter the animal number (not the id) from the list");

		int animalNumber = scanner.nextInt();
		scanner.nextLine();

		showNonExpiredVaccines();
		System.out.println("Enter the vaccine id");

		String vaccineId = scanner.nextLine();

		boolean vaccineApplied = adminController.applyVaccineToAnimal(animalNumber, vaccineId);

		if(vaccineApplied) {
			System.out.println("Vaccine applied successfully");
		} else {
			System.out.println("Vaccine not applied");
		}


	}

	private static void createNewVaccine(Scanner scanner) {
		System.out.println("Creating a new vaccine");
		System.out.println("Please enter the batch number of the vaccine");
		String batchNumber = scanner.nextLine();

		System.out.println("Please enter the volume of the vaccine");
		int volume = Integer.valueOf(scanner.nextLine());

		System.out.println("Please enter the brand of the vaccine");
		String brand = scanner.nextLine();

		System.out.println("Please enter the date of expiration of the vaccine (remember to use the format yyyy-mm-dd)");
		String dateOfExpiration = scanner.nextLine();

		UUID idCreated = adminController.addVaccine(batchNumber, volume, brand, dateOfExpiration);

		if (idCreated != null) {
			System.out.println("Vaccine created with id: " + idCreated);
		} else {
			System.out.println("Vaccine not created");
		}
	}

	private static void createNewAnimal(Scanner scanner) {
		System.out.println("Please enter the name of the animal");
		String name = scanner.nextLine();

		System.out.println("Please enter the age of the animal");
		int age = Integer.valueOf(scanner.nextLine());

		UUID idCreated = adminController.addAnimal(name, age);

		if (idCreated != null) {
			System.out.println("Animal created with id: " + idCreated);
		} else {
			System.out.println("Animal not created");
		}

	}


}
