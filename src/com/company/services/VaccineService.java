package com.company.services;

import com.company.model.Vaccine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VaccineService {

    private List<Vaccine> vaccines = new ArrayList<Vaccine>();

    public List<Vaccine> getVaccines() {
        //Alternative
        //return new ArrayList<>(vaccines);
        return this.vaccines;
    }

    public List<Vaccine> getNonExpiredVaccines() {
        List<Vaccine> nonExpiredVaccines = new ArrayList<>();
        LocalDate todayDate = LocalDate.now();
        for (Vaccine vaccine : this.vaccines) {
            if (vaccine.getDateOfExpiration().isAfter(todayDate)) {
                nonExpiredVaccines.add(vaccine);
            }
        }
        return nonExpiredVaccines;
    }

    public UUID addVaccine(String batchNumber, int volume, String brand, LocalDate dateOfExpiration) {
        Vaccine vaccine = new Vaccine(batchNumber, volume, brand, dateOfExpiration);
        this.vaccines.add(vaccine);
        return vaccine.getId();
    }

    public Vaccine findVaccineById(UUID vaccineUUID) {
        for (Vaccine vaccine : this.vaccines) {
            if (vaccine.getId().equals(vaccineUUID)) {
                return vaccine;
            }
        }

        return null;

    }

    public boolean deleteVaccine(UUID vaccineUUID) {
        for (Vaccine vaccine : this.vaccines) {
            if (vaccine.getId().equals(vaccineUUID)) {
                return this.vaccines.remove(vaccine);
            }
        }
        return false;
    }
}
