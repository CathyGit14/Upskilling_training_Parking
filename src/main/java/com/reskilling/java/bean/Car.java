/*
Voici les caractéristiques d'une voiture
Une voiture est un véhicule ;
Quand il se voit accepter dans un parking il écrit dans la console un message légèrement différent "vroum ! vroum ! ma couleur est COULEUR-VEHICULE et je peux rentrer dans le parking" ;
*/

package com.reskilling.java.bean;

public class Car extends Vehicle {

    public Car() {
        super();
    }

    @Override
    public String entreeParking(){
        return "vroum ! vroum ! ma couleur est " + getvehicleColor() + " et je peux rentrer dans le parking";
    }
}
