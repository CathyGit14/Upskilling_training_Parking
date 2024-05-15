/*package com.reskilling.java.gestion;
import com.reskilling.java.bean.Vehicle;
import com.reskilling.java.bean.*;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Gestion {

    private final List<String> vehicleType = Arrays.asList("Car","Moto","Bike");
    private Boolean havePlace = false;

    private HashMap<String, Integer> vehicleCounter = new HashMap<>();
    private HashMap<String, Integer> vehicleColorType = new HashMap<>();

    public Gestion() {
    }

    public Gestion(Vehicle vehicle) {
        for(String vehicleT : vehicleType){
            vehicleCounter.put(vehicleT,0);
        }
        for(String vehicleC : vehicle.getPossibleColor()){
            vehicleColorType.put(vehicleC,0);
        }

    }

    public String getVehicleType(int number){
        return vehicleType.get(number);
    }

    public List<String> getVehicleType() {
        return vehicleType;
    }

    public int getvehicleCounter(String name) {
        return vehicleCounter.get(name);
    }

    public int getNumberVehicleOfThisColor(String color){
        return vehicleColorType.get(color);
    }

    public int getVehicleTypeQuantity(){
        return vehicleType.size();
    }

    public Boolean addVehicle (Vehicle vehicle, Parking parking){
        int numberOfPlace = 0;
        String vehicleName = vehicle.getClass().getSimpleName();
        switch (vehicleName){
            case "Car" :
                numberOfPlace = parking.getCarSpot();
                break;
            case "Moto" :
                numberOfPlace = parking.getMotoSpot();
                break;
            case "Bike" :
                numberOfPlace = parking.getBikeSpot();
                break;
            default:
                numberOfPlace = 0;
                break;
        }
        if(vehicleCounter.get(vehicleName) < numberOfPlace){
            vehicleCounter.put(vehicleName, vehicleCounter.get(vehicleName)+1);
            vehicleColorType.put(vehicle.getvehicleColor(), vehicleColorType.get(vehicle.getvehicleColor())+1);
            havePlace = true;
        }else{
            havePlace = false;
        }
        return havePlace;
    }

    public void entryMessage(Boolean havePlace, Vehicle vehicle){
        if (havePlace != null && havePlace){
            System.out.println(vehicle.entreeParking());
        }else {
            System.out.println(vehicle.refusParking());
        }
    }
}
*/


