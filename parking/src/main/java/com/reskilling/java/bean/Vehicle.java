/*
Voici les caractéristiques d'un véhicule
Un véhicule à une couleur attribuée aléatoirement à sa création. Cette couleur est soit bleu ou blanc ou noir ou rose ;
Quand il se voit accepter dans un parking il écrit dans la console "chouette, ma couleur est COULEUR-VEHICULE et je peux rentrer dans le parking" ;
Quand il se voit refuser dans un parking il écrit dans la console "zut je ne peux pas rentrer dans le parking" ;
 */
package com.reskilling.java.bean;

import com.reskilling.java.utils.ParkingUtils;


import java.util.Arrays;
import java.util.List;

public class Vehicle {
    private String vehicleColor;
    private List<String> possibleColor = Arrays.asList("BLEU","BLANC","NOIR","ROSE");

    public List<String> getPossibleColor() {
        return possibleColor;
    }

    public String getvehicleColor() {
        return vehicleColor;
    }

    public void setvehicleColor(int index) {
        this.vehicleColor = possibleColor.get(index);
    }

    public Vehicle() {
        int number = ParkingUtils.generateRandomNumber(possibleColor.size());
        setvehicleColor(number);
    }

    public String entreeParking (){
        return "chouette, ma couleur est " + getvehicleColor() +
                 " et je peux rentrer dans le parking";
    }

    public String refusParking (){
        return "zut, je ne peux pas rentrer dans le parking";
    }


}
