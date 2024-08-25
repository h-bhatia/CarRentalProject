  package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem  
{
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	String customerName=null;
	String confirm=null;
	public CarRentalSystem() {
	super();
		cars = new ArrayList<>();
		customers =new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	

	public void addCar(Car car)
	{
	cars.add(car);
	}
   public void addCustomer(Customer customer)
   {
	   customers.add(customer);
   }
public void rentCar(Car car,Customer customer,int days)
{
	if(car.isAvailable())
	{
		car.rent();
		rentals.add(new Rental(car, customer, days));
		
	}
	else {
		System.out.println("car is not available for rent");
	}
}

// car return
public void returnCar(Car car)
{
	car.returnCar();
	Rental rentalToRemove=null;
	for(Rental rental: rentals)
	{
		if(rental.getCar()==car)
		{
			rentalToRemove=rental;
			break;
		}
	}
	if(rentalToRemove!=null)
	{
		rentals.remove(rentalToRemove);
		System.out.println("car returned successfully");
	}
	else {
		System.out.println("car was not rented");
	}
	
	
}


public void menu()
{
	
	Scanner scanner =new Scanner(System.in);
	while(true)
	{
		System.out.println("====Car Rental System====");
		System.out.println("1. Rent a Car");
		System.out.println("2 Return a Car");
		System.out.println("3 Exit");
		System.out.println("enter your choices");
		int choice =scanner.nextInt();
		scanner.nextLine();
		if(choice ==1)
		{
			System.out.println("\n== Rent  a Car ==\n");
			System.out.println("enter your name");
		  customerName=scanner.nextLine();
			System.out.println("\n Available cars :");
			for(Car car:cars)
			{
				if(car.isAvailable())
				{
					System.out.println(car.getCarId()+ " -" +car.getBrand()+ " "+car.getModel());
					
				}
		}
		System.out.println("enter the car id u want to rent");
		String carId=scanner.nextLine();
		System.out.println("Enter the no of days for rental");
		int rentalDays=scanner.nextInt();
		Customer newCustomer=new Customer("CUS" + (customers.size()+1),customerName);
		addCustomer(newCustomer);
		Car selectedCar=null;
		for(Car car: cars)
		{
			if (car.getCarId().equals(carId)&& car.isAvailable())
			{
			selectedCar=car;
			break;
			}
		}
		if(selectedCar!=null)
		{
			double totalPrice=selectedCar.calculatePrice(rentalDays);
			System.out.println("\n == Reantal Information  ==\n");
			System.out.println("customer Id "+newCustomer.getCustomerId());
			System.out.println("customer Name "+newCustomer.getName());
			System.out.println("car: " +selectedCar.getBrand()+ " " +selectedCar.getModel());
			System.out.println("rental days" +rentalDays);
			System.out.println("Total price " +totalPrice);
			System.out.println("\n confirm reental (Y/N): ");
               confirm=scanner.next();
			if(confirm.equalsIgnoreCase("Y"))
			{
				rentCar(selectedCar, newCustomer, rentalDays);
				System.out.println("car rented successfully");
			}
			else{
				System.out.println("Rental cancelled");
			}
		}
			else {
				System.out.println("Invalid car selection or not car not available for rent");
			}
	}
         else if (choice==2) {
			System.out.println("\n== return a Car==\n ");
			System.out.println("enter the car id u want to return");
			String carId=scanner.nextLine();
			Car carToReturn=null;
			for(Car car : cars)
			{
				if(car.getCarId().equals(carId) && !car.isAvailable())
				{
					carToReturn=car;
					break;
				}
			}
			if(carToReturn!=null)
			{
				Customer customer=null;
			for(Rental rental:rentals)
			{
				if(rental.getCar()== carToReturn)
				{
					customer=rental.getCustomer();
					break;
				}
			}
			
			if(customer!=null)
			{
				returnCar(carToReturn);
				System.out.println("car returned succesfully  by "+customer.getName());
				}
			else {
				System.out.println("car was not rented or rental information is missing");
			}
			}
			else {
				System.out.println("invalid car id or car is not rented");
			}
         }
         else if(choice==3)
         {
        	 break;
         }
         else {
			System.out.println("invalid choice please enter a valid option");
		}
		
			
		} 
	System.out.println("thank you for using car rental system");
	
}


}
