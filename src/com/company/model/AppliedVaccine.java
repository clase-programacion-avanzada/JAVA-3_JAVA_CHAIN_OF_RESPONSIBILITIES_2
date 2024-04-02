package com.company.model;

import java.time.LocalDate;

public class AppliedVaccine {

    private Vaccine vaccine;
    //https://javautodidacta.es/tiempo-en-java-localdate-localtime/
    //https://www.baeldung.com/java-creating-localdate-with-values
    private LocalDate dateOfVaccine;

    public AppliedVaccine(Vaccine vaccine, LocalDate dateOfVaccine) {
        this.vaccine = vaccine;
        this.dateOfVaccine = dateOfVaccine;
    }

    public AppliedVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
        this.dateOfVaccine = LocalDate.now();
    }

    public AppliedVaccine(String batchNumber,
                          int volume,
                          String brand,
                          LocalDate dateOfVaccine,
                          LocalDate dateOfExpiration) {

        this.vaccine = new Vaccine(batchNumber,
            volume,
            brand,
            dateOfExpiration);

        this.dateOfVaccine = dateOfVaccine;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public LocalDate getDateOfVaccine() {
        return dateOfVaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void setDateOfVaccine(LocalDate dateOfVaccine) {
        this.dateOfVaccine = dateOfVaccine;
    }

    @Override
    public String toString() {
        return "Vaccine: " + vaccine.getBrand() + " - " + vaccine.getVolume() + " ml."
            + " Date when applied: " + dateOfVaccine;
    }

}
