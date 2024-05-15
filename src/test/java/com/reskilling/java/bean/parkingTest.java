package com.reskilling.java.bean;

import com.reskilling.java.bean.Parking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;

public class parkingTest {
    private Parking parkingUnderTest;

    @BeforeEach
    public void initParking(){
        parkingUnderTest = new Parking();
    }

    @Test
    @Tag("ParkingSpotsForCar")
    public void carSpotsCanNotBeLesserThan10(){
        assertThrows(IllegalArgumentException.class, () -> {
            parkingUnderTest.setCarSpot(9);
        });
    }

    @Test
    @Tag("ParkingSpotsForMoto")
    public void motoSpotsCanNotBeLesserThan1(){
        assertThrows(IllegalArgumentException.class, () -> {
            parkingUnderTest.setMotoSpot(0);
        });
    }

/*
    @Test
    @Tag("ParkingSpotsForMoto")
    public void motoDefautSpotWas15(){
        final int result = parkingUnderTest.getMotorcycleSpot();
        assertThat(result).isEqualTo(15);
    }

    @Test
    @Tag("ParkingSpotsForBike")
    public void bikeSpotsMustBeBetween1And10(){
        parkingUnderTest.setBikeSpot(0);
        final int testLessThan1 = parkingUnderTest.getBikeSpot();
        assertThat(testLessThan1,allOf(
                greaterThanOrEqualTo(1),
                lessThanOrEqualTo(10)
        ));

        parkingUnderTest.setBikeSpot(11);
        final int testMoreThan10 = parkingUnderTest.getBikeSpot();
        assertThat(testMoreThan10,allOf(
                greaterThanOrEqualTo(1),
                lessThanOrEqualTo(10)
        ));
 */

}
