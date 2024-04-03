package com.company.model;

import java.time.LocalDate;
import java.util.UUID;

public class Vaccine {

	private UUID id = UUID.randomUUID();
	private String batchNumber;
	private int volume;
	private String brand;
	private LocalDate dateOfExpiration;

	/**
	 * @param batchNumber
	 * @param volume
	 * @param brand
	 * @param dateOfExpiration
	 */

	public Vaccine(String batchNumber, int volume, String brand, LocalDate dateOfExpiration) {

		this.batchNumber = batchNumber;
		this.volume = volume;
		this.brand = brand;
		this.dateOfExpiration = dateOfExpiration;

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

	public UUID getId() {
		return id;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public LocalDate getDateOfExpiration() {
		return dateOfExpiration;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setDateOfExpiration(LocalDate dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	@Override
	public String toString() {
		return "id: " + id
			+ " | batchNumber: " + batchNumber
			+ " | volume: " + volume
			+ " | brand: " + brand
			+ " | dateOfExpiration: " + dateOfExpiration;
	}
}
