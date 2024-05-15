/*
Voici les caractéristiques d'une moto
Une moto est un véhicule ;
Une moto est soit une HARLEY ou une SUZUKI. Typologie attribuée aléatoirement à la création ;
Quand il se voit accepter dans un parking il écrit dans la console un message légèrement différent "youpi ! ma couleur est COULEUR-VEHICULE et je peux rentrer dans le parking" ;
 Quand il se voit refuser dans un parking il écrit dans la console un message légèrement différent "hey ! je suis une TYPE-DE-MOTO vous allez regretter de ne pas m’avoir laissé entrer" ;
 */
package com.reskilling.java.bean;

import com.reskilling.java.utils.ParkingUtils;

public class Moto extends Vehicle {
    private Marque marque;
    private enum Marque {HARLEY, SUZUKI}

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Moto() {
        int randNumber = ParkingUtils.generateRandomNumber(Marque.values().length);
        setMarque(Marque.values()[randNumber]);
    }

    @Override
    public String entreeParking (){
        return "youpi ! ma couleur est " + getvehicleColor() +
                " et je peux rentrer dans le parking";
    }

    @Override
    public String refusParking (){
        return "hey ! je suis une " + getMarque() +
                " vous allez regretter de ne pas m’avoir laissé entrer";
    }
}
