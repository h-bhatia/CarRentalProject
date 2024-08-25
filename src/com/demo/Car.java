package com.demo;

public class Car 
{
private String carId;
private String brand;
private String model;
private double basePricePerDay;
private boolean isAvailable;
public Car(String carId, String brand, String model, double basePricePerDay, boolean isAvailable) {
	super();
	this.carId = carId;
	this.brand = brand;
	this.model = model;
	this.basePricePerDay = basePricePerDay;
	this.isAvailable = true;
}
/**
 * @return the carId
 */
public String getCarId() {
	return carId;
}
/**
 * @param carId the carId to set
 */
public void setCarId(String carId) {
	this.carId = carId;
}
/**
 * @return the brand
 */
public String getBrand() {
	return brand;
}
/**
 * @param brand the brand to set
 */
public void setBrand(String brand) {
	this.brand = brand;
}
/**
 * @return the model
 */
public String getModel() {
	return model;
}
/**
 * @param model the model to set
 */
public void setModel(String model) {
	this.model = model;
}
/**
 * @return the basePricePerDay
 */
public double getBasePricePerDay() {
	return basePricePerDay;
}
/**
 * @param basePricePerDay the basePricePerDay to set
 */
public void setBasePricePerDay(double basePricePerDay) {
	this.basePricePerDay = basePricePerDay;
}
/**
 * @return the isAvailable
 */
public boolean isAvailable() {
	return isAvailable;
}
/**
 * @param isAvailable the isAvailable to set
 */
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
	
public void rent()
{
	isAvailable=false;
}

public void returnCar()
{
	isAvailable=true;
}
public double calculatePrice(int rentalDays)
{
	return basePricePerDay * rentalDays;
}


	
}
