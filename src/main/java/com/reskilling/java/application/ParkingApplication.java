/*
Initialise un parking avec les variables NOM , X et Y passés en arguments d’entrée obligatoires (sauf pour Y qui est facultatif) au programme ;
Fais rentrer des véhicules les uns après les autres avec un TYPE-DE-VEHICULE aléatoire ;
Le programme s’arrête quand le parking ne dispose plus de places pour vélos et retourne le nombre de véhicules actuellement dans le parking dont la couleur est égale à celle passée en entrée du programme.
 */
package com.reskilling.java.application;

import com.reskilling.java.bean.*;
import com.reskilling.java.utils.ParkingUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class ParkingApplication {
	private final static List<String> vehicleType = Arrays.asList("Car","Moto","Bike");

	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(ParkingApplication.class, args);
		Parking parking = null;

		parking = initParking(parking, args);

		Vehicle vehicle = new Vehicle();

		String color;


		while (parking.numberOfThisTypeVehicle("Bike") < parking.getBikeSpot()) {
			vehicle = createNewVehicle(vehicle);
			checkEntryParking(vehicle, parking);
		}
		// Parking application end -> no more Bike spaces in the parking
		color = vehicle.getvehicleColor();
		for(String vehicleName : vehicleType){
			System.out.println(vehicleName + " : " + parking.numberOfThisTypeVehicle(vehicleName));
		}

		System.out.println("Couleur : " + vehicle.getvehicleColor());
		System.out.println("Nombre de véhicule " + color + " : "
				+ parking.numberVehicleFromColor(color));

	}

	public static Parking initParking(Parking parking, String[] parameters) throws InvalidParameterException{
		try {
			if (parameters.length == 3) {
				parking = new Parking(parameters[0], parameters[1], parameters[2]);
			} else if (parameters.length == 2) {
				parking = new Parking(parameters[0], parameters[1]);
			}else {
				throw new InvalidParameterException();
			}
		}catch (InvalidParameterException ex){
			throw new InvalidParameterException("Format paramétrage attendu : String Int Int(Facultatif)");
		}
		return parking;
	}

	public static Vehicle createNewVehicle(Vehicle vehicle) throws ClassNotFoundException {
		// Create a random type of vehicle
		int randNumber = ParkingUtils.generateRandomNumber(vehicleType.size());
		try {
			switch (randNumber) {
				case 0:
					vehicle = new Car();
					break;
				case 1:
					vehicle = new Moto();
					break;
				case 2:
					vehicle = new Bike();
					break;
				default:
					throw new ClassNotFoundException();
			}
/*
				String className = gestion.getVehicleType(randNumber);
				Object cls = Class.forName("com.reskilling.java.bean." + className).getDeclaredConstructor().newInstance();
				vehicle = (Vehicle) cls;

			}catch (NoSuchMethodException | InstantiationException |
					IllegalAccessException | InvocationTargetException ex){
					System.out.println(ex);
*/
		} catch (ClassNotFoundException ex){
			throw new ClassNotFoundException("Class not found " + ex.toString());
		}
		return vehicle;
	}

	public static void checkEntryParking(Vehicle vehicle, Parking parking) {
		String vehicleName = vehicle.getClass().getSimpleName();
		int numberAvailableSpotForXVehicle = numberAvailableSpot(vehicleName, parking);

		if(parking.numberOfThisTypeVehicle(vehicleName) < numberAvailableSpotForXVehicle){
			parking.addVehicle(vehicle);
			System.out.println(vehicle.entreeParking());
		}else {
			System.out.println(vehicle.refusParking());
		}
	}

	public static int numberAvailableSpot(String vehicleName, Parking parking) {
		int numberAvailableSpot;
		switch (vehicleName) {
			case "Car":
				numberAvailableSpot = parking.getCarSpot();
				break;
			case "Moto":
				numberAvailableSpot = parking.getMotoSpot();
				break;
			case "Bike":
				numberAvailableSpot = parking.getBikeSpot();
				break;
			default:
				throw new IllegalArgumentException("Spot for " + vehicleName + " not found");
		}
		return numberAvailableSpot;
	}


}
