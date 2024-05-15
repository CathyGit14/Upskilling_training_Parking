package com.reskilling.java.utils;

import java.security.SecureRandom;

public class ParkingUtils {

    public static int generateRandomNumber (int n){
        if (n <= 0){
            throw new IllegalArgumentException("n ne peut être négatif où null");
        }
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(n);
    }
}
