package com.company;

import com.company.controllers.AdminController;
import com.company.services.AnimalService;
import com.company.services.VaccineService;
import com.company.view.AdminView;
import java.util.List;

import java.util.Scanner;
import java.util.UUID;

public class Main {


	public static void main(String[] args) {

		// First we create the services
		AnimalService animalService = new AnimalService();
		VaccineService vaccineService = new VaccineService();


		// Then we create the controller and set the services
		AdminController adminController = new AdminController(animalService, vaccineService);

		// Then we create the view and set the controller of the view
		Scanner scanner = new Scanner(System.in);
		AdminView adminView = new AdminView(adminController, scanner);

		int option;

		// Java text blocks
		// https://www.baeldung.com/java-text-blocks
		String menu = """ 
			=========================================
			Welcome to the Animal Vaccination System
			=========================================

			Select a module to continue:

			1. Admin module (administrator operations, such as adding animals and vaccines)
			0. Exit
			""";

		do {

			System.out.println(menu);
			option = Integer.parseInt(scanner.nextLine().trim());

			switch(option) {


				case 1 -> adminView.showMenu();
				case 0 -> System.out.println("Exiting the system");
				default -> System.out.println("Invalid option");
			}

		} while(option != 0);
		
		scanner.close();
		
	}




}
