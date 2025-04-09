package com.company.view;

import com.company.controllers.AdminController;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AdminView {

    public static final String MENU = """
        =========================================
                  Administrator module
        =========================================
        
        Select an option to continue:
        
         1. Create new animal
         2. Create a new vaccine
         3. Apply vaccine to an animal
         4. Show all animals
         5. Show all vaccines
         6  Show vaccines applied to an animal
         7. Delete a vaccine
         8. Delete an animal
         0. Exit
        """;
    private AdminController adminController;

    private Scanner scanner;

    public AdminView(AdminController adminController, Scanner scanner) {
        this.adminController = adminController;
        this.scanner = scanner;
    }

    public void showMenu() {


        int option;

        do {
            System.out.println(MENU);
            System.out.println("Enter an option");
            option = Integer.parseInt(scanner.nextLine().trim());

            switch (option) {
                case 1 -> createNewAnimal(scanner);
                case 2 -> createNewVaccine(scanner);
                case 3 -> applyVaccineToAnimal(scanner);
                case 4 -> showAllAnimals();
                case 5 -> showAllVaccines();
                case 6 -> showVaccinesAppliedToAnimal(scanner);
                case 7 -> deleteVaccine(scanner);
                case 8 -> deleteAnimal(scanner);
                case 0 -> System.out.println("Moving back to the main menu");
                default -> System.out.println("Invalid option");
            }

        } while (option != 0);

    }

    private void deleteVaccine(Scanner scanner) {
        showAllVaccines();
        System.out.println("Enter the vaccine id to be deleted");

        String vaccineNumber = scanner.nextLine();

        System.out.println("Are you sure you want to delete the vaccine with id " + vaccineNumber + "? (y/n)");
        String confirmation = scanner.nextLine();

        if (confirmation.equals("y")) {
            boolean vaccineDeleted = adminController.deleteVaccine(vaccineNumber);

            if(vaccineDeleted) {
                System.out.println("Vaccine deleted successfully");
            } else {
                System.out.println("Vaccine not deleted");
            }
        }

        System.out.println("Moving back to the menu");


    }

    private  void deleteAnimal(Scanner scanner) {
        System.out.println("Enter the animal number (not the id)");
        showAnimalNamesAndIds();

        int animalNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Are you sure you want to delete the animal with number " + animalNumber + "? (y/n)");

        String confirmation = scanner.nextLine();

        if (confirmation.equals("y")) {
            boolean animalDeleted = adminController.deleteAnimal(animalNumber);

            if(animalDeleted) {
                System.out.println("Animal deleted successfully");
            } else {
                System.out.println("Animal not deleted");
            }
        }

        System.out.println("Moving back to menu");


    }

    private void showVaccinesAppliedToAnimal(Scanner scanner) {
        System.out.println("Enter the animal number (not the id)");
        showAnimalNamesAndIds();

        int animalNumber = scanner.nextInt();
        scanner.nextLine();

        List<String> vaccinesAppliedToAnimal = adminController.getVaccinesAppliedToAnimal(animalNumber);
        for(String vaccine : vaccinesAppliedToAnimal) {
            System.out.println(vaccine);
        }

    }

    private void showAnimalNamesAndIds() {
        List<String> animals = adminController.getAnimalIdAndNames();
        for(String animal : animals) {
            System.out.println(animal);
        }
    }

    private void showAllVaccines() {
        System.out.println("These are all the vaccines:");
        List<String> vaccines = adminController.getVaccines();
        for(String vaccine : vaccines) {
            System.out.println(vaccine);
        }
    }

    private void showNonExpiredVaccines() {
        System.out.println("These are all the vaccines:");
        List<String> vaccines = adminController.getNonExpiredVaccines();
        for(String vaccine : vaccines) {
            System.out.println(vaccine);
        }
    }

    private void showAllAnimals() {
        System.out.println("These are all the animals:");
        List<String> animals = adminController.getAnimals();
        for(String animal : animals) {
            System.out.println(animal);
        }

    }

    private void applyVaccineToAnimal(Scanner scanner) {
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

    private void createNewVaccine(Scanner scanner) {
        System.out.println("Creating a new vaccine");
        System.out.println("Please enter the batch number of the vaccine");
        String batchNumber = scanner.nextLine();

        System.out.println("Please enter the volume of the vaccine");
        int volume = Integer.parseInt(scanner.nextLine());

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

    private void createNewAnimal(Scanner scanner) {
        System.out.println("Please enter the name of the animal");
        String name = scanner.nextLine();

        System.out.println("Please enter the age of the animal");
        int age = Integer.parseInt(scanner.nextLine());

        UUID idCreated = adminController.addAnimal(name, age);

        if (idCreated != null) {
            System.out.println("Animal created with id: " + idCreated);
        } else {
            System.out.println("Animal not created");
        }

    }
}
