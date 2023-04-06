package com.company.model;

import java.time.LocalDate;

public class Vaccine {
	
	private LocalDate dateOfVaccine;
	private int volume;
	private String brand;
	
	
	
	public Vaccine(LocalDate dateOfVaccine, int volume, String brand) {
		
		this.dateOfVaccine = dateOfVaccine;
		this.volume = volume;
		this.brand = brand;
	}
	
	public Vaccine(int volume, String brand) {
		
		this.dateOfVaccine = LocalDate.now();
		this.volume = volume;
		this.brand = brand;
	}
	
	/**
	 * @return the dateOfVaccine
	 */
	public LocalDate getDateOfVaccine() {
		return dateOfVaccine;
	}
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param dateOfVaccine the dateOfVaccine to set
	 */
	public void setDateOfVaccine(LocalDate dateOfVaccine) {
		this.dateOfVaccine = dateOfVaccine;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}
