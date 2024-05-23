/*
Voici les caractéristiques d’un parking :
 Il a un NOM (axeo par exemple) ;
 Il dispose de 10 à X places pour voiture ;
 Il dispose de 1 à Y places pour moto ; Y vaut 15 par défaut.
 Il dispose de 1 à 10 places pour vélo ;
 Quand un véhicule lui demande de rentrer, il vérifie s'il lui reste de la place pour ce type de véhicule et lui répond par OUI ou par NON ;
 S'il répond non à un véhicule, il écrit en console "je suis le parking NOM-DU-PARKING et je viens de refuser un(e) TYPE-DE-VEHICULE" ;
S'il répond oui à un véhicule, il écrit en console "je suis le parking NOM-DU-PARKING et je viens d'accepter un(e) TYPE-DE-VEHICULE. Il me reste maintenant X places pour ce TYPE-DE-VEHICULE".
 Si on lui indique une couleur, il est capable d’indiquer dans la console "je suis le parking NOM-DU-PARKING et j’ai X véhicules COULEUR-VEHICULE en mon antre".
 */
package com.reskilling.java.bean;

import com.reskilling.java.utils.ParkingUtils;

import java.util.ArrayList;

public class Parking {


    private String nom;
    private static final int CAR_MIN = 10;
    private static final int MOTO_MIN = 1;
    private static final int BIKE_MIN = 1;
    private static final int BIKE_MAX = 10;
    private static final int MOTOYDEFAULT = 15;
    private int carSpot;
    private int motoSpot = MOTOYDEFAULT;
    private int bikeSpot;
    private ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

    public Parking() {
    }

    public Parking(String nom, String carSpot) {
        this.nom = nom;
        setCarSpot(Integer.valueOf(carSpot));
        setBikeSpot(defineNumberBikesSpot());
    }

    public Parking(String nom, String carSpot, String motoSpot) {
        this.nom = nom;
        setCarSpot(Integer.valueOf(carSpot));
        setMotoSpot(Integer.valueOf(motoSpot));
        setBikeSpot(defineNumberBikesSpot());
    }

    public int getCarSpot() {
        return carSpot;
    }

    public void setCarSpot(int carSpot) {
        if (carSpot < CAR_MIN){
            throw new IllegalArgumentException("Voiture : il ne peut y avoir moins de 10 places");
        }else {
            this.carSpot = carSpot;
        }
    }

    public int getMotoSpot() {
        return motoSpot;
    }

    public void setMotoSpot(int motoSpot) {
        if (motoSpot < MOTO_MIN){
            throw new IllegalArgumentException("Moto : il ne peut y avoir moins de 1 place");
        }else {
            this.motoSpot = motoSpot;
        }
    }

    public int getbikeMax() {
        return BIKE_MAX;
    }

    public int getBikeSpot() {
        return bikeSpot;
    }

    public void setBikeSpot(int bikeSpot) {
        while(bikeSpot < BIKE_MIN || bikeSpot > BIKE_MAX){
            bikeSpot = ParkingUtils.generateRandomNumber(BIKE_MAX);
        }
        this.bikeSpot = bikeSpot;
    }

    public int defineNumberBikesSpot(){
        this.bikeSpot = ParkingUtils.generateRandomNumber(getbikeMax());
        return bikeSpot;
    }

    public void addVehicle(Vehicle vehicle){
        vehicleArrayList.add(vehicle);
    }

    public int numberOfThisTypeVehicle(String vehicleType){
        long numberOfVehicleType;
        numberOfVehicleType =
                vehicleArrayList.stream()
                .filter(vehicle -> vehicle.getClass().getSimpleName().contains(vehicleType))
                .count();
        return (int)numberOfVehicleType;
    }

    public int numberVehicleFromColor(String color){
        long numberOfColor;
        numberOfColor =
                vehicleArrayList.stream()
                .filter(vehicle -> vehicle.getvehicleColor().contains(color))
                .count();
        return (int) numberOfColor;
    }

}
