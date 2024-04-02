package com.company.services;

import com.company.model.Animal;
import com.company.model.AppliedVaccine;
import com.company.model.Vaccine;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimalService {

    private List<Animal> animals;

    public AnimalService() {
        this.animals = new ArrayList<Animal>();
    }

    public List<Animal> getAnimals() {
        //Alternative
        //return new ArrayList<>(animals);
        return this.animals;
    }


    public UUID addAnimal(Animal animal) {
        return this.animals.add(animal)
            ? animal.getId()
            : null;
    }

    public UUID addAnimal(String name, int age) {
        Animal animal = new Animal(name, age);
        return this.animals.add(animal)
            ? animal.getId()
            : null;
    }

    public boolean removeAnimal(Animal animal) {

        return this.animals.remove(animal);
    }

    public boolean removeAnimal(UUID animalId) {
        for (Animal animal : this.animals) {
            if (animal.getId().equals(animalId)) {
                return this.animals.remove(animal);
            }
        }

        return false;
    }

    public boolean removeAnimal(int animalNumber) {
        if (animalNumber < 0 || animalNumber >= this.animals.size()) {
            return false;
        }
        return this.animals.remove(animalNumber) != null;
    }

    public Animal findAnimalById(UUID animalId) {
        for (Animal animal : this.animals) {
            if (animal.getId().equals(animalId)) {
                return animal;
            }
        }

        return null;

    }



    public List<AppliedVaccine> getVaccinesAppliedToAnimal(int animalNumber) {
        //Alternative
        //return new ArrayList<>(animals.get(animalNumber).getAppliedVaccines());
        return this.animals.get(animalNumber).getAppliedVaccines();
    }

    public boolean applyVaccineToAnimal(int animalNumber, Vaccine vaccine) {
        Animal animal = this.animals.get(animalNumber);

        return animal.applyVaccine(vaccine);
    }

    public boolean deleteVaccineFromAllAnimals(UUID vaccineUUID) {
        boolean vaccineDeleted = false;
        for (Animal animal : this.animals) {
            if (animal.deleteVaccine(vaccineUUID)) {
                vaccineDeleted = true;
            }
        }
        return vaccineDeleted;
    }
}
