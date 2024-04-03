package com.company.controllers;

import com.company.model.Animal;
import com.company.model.AppliedVaccine;
import com.company.model.Vaccine;
import com.company.services.AnimalService;
import com.company.services.VaccineService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminController {

    private AnimalService animalService;

    private VaccineService vaccineService;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AdminController(AnimalService animalService, VaccineService vaccineService) {
        this.animalService = animalService;
        this.vaccineService = vaccineService;
    }

    public AdminController() {
        this(new AnimalService(), new VaccineService());
    }

    public UUID addAnimal(String name, int age) {

        return animalService.addAnimal(name, age);
    }

    public UUID addVaccine(String batchNumber,
                           int volume,
                           String brand,
                           String dateOfExpiration) {
        LocalDate date = LocalDate.parse(dateOfExpiration, formatter);
        return vaccineService.addVaccine(batchNumber, volume, brand, date);
    }

    public List<String> getAnimals() {
        List<Animal> animals = animalService.getAnimals();
        List<String> animalsToShow = new ArrayList<>();

        int index = 0;
        for (Animal animal : animals) {

            animalsToShow.add(index +") " + animal.toString());
            index++;
        }

        return animalsToShow;
    }

    public List<String> getVaccines() {
        List<Vaccine> vaccines = vaccineService.getVaccines();
        List<String> vaccinesToShow = new ArrayList<>();

        for(int i = 0; i < vaccines.size(); i++) {
            Vaccine vaccine = vaccines.get(i);
            vaccinesToShow.add(i + ") " + vaccine.toString());
        }

        return vaccinesToShow;
    }

    public List<String> getNonExpiredVaccines() {
        List<Vaccine> vaccines = vaccineService.getNonExpiredVaccines();

        List<String> vaccinesToShow = new ArrayList<>();

        for(int i = 0; i < vaccines.size(); i++) {
            Vaccine vaccine = vaccines.get(i);
            vaccinesToShow.add(vaccine.toString());
        }

        return vaccinesToShow;
    }

    public List<String> getAnimalIdAndNames() {
        List<Animal> animals = animalService.getAnimals();
        List<String> animalsToShow = new ArrayList<>();

        int index = 0;
        for (Animal animal : animals) {
            animalsToShow.add(index +") " + animal.toIdAndName());
            index++;
        }

        return animalsToShow;
    }

    public List<String> getVaccinesAppliedToAnimal(int animalNumber) {
        List<AppliedVaccine> vaccines = animalService.getVaccinesAppliedToAnimal(animalNumber);

        List<String> vaccinesToShow = new ArrayList<>();

        if (vaccines == null || vaccines.isEmpty()) {
            vaccinesToShow.add("No vaccines applied to this animal");
            return vaccinesToShow;
        }

        for(int i = 0; i < vaccines.size(); i++) {
            AppliedVaccine vaccine = vaccines.get(i);
            vaccinesToShow.add(i + ") " + vaccine.toString());
        }

        return vaccinesToShow;
    }


    public boolean applyVaccineToAnimal(int animalPosition, String vaccineId) {
        UUID vaccineUUID = UUID.fromString(vaccineId);
        Vaccine vaccineToApply = vaccineService.findVaccineById(vaccineUUID);

        if (vaccineToApply == null) {
            return false;
        }

        return animalService.applyVaccineToAnimal(animalPosition, vaccineToApply);

    }

    public boolean deleteAnimal(int animalPosition) {
        return animalService.removeAnimal(animalPosition);
    }

    public boolean deleteVaccine(String vaccineId) {
        UUID vaccineUUID = UUID.fromString(vaccineId);
        animalService.deleteVaccineFromAllAnimals(vaccineUUID);
        return vaccineService.deleteVaccine(vaccineUUID);
    }
}
