package com.reskilling.java.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ParkingTest {
    @Mock
    Car car;
    @Mock
    Moto moto;
    @Mock
    Bike bike;

    private Parking parkingUnderTest;

    @BeforeEach
    void initParking(){
        parkingUnderTest = new Parking();
    }

    @Test
    @Tag("ParkingSpotsForCar")
    void carSpotsCanNotBeLesserThan10(){
        assertThrows(IllegalArgumentException.class, () -> {
            parkingUnderTest.setCarSpot(9);
        });
    }

    @Test
    @Tag("ParkingSpotsForMoto")
    void motoSpotsCanNotBeLesserThan1(){
        assertThrows(IllegalArgumentException.class, () -> {
            parkingUnderTest.setMotoSpot(0);
        });
    }

//    @Test
//    public void
    @Test
    @Tag("ParkingSpotsForMoto")
    void motoDefautSpotWas15(){
        final int result = parkingUnderTest.getMotoSpot();
        assertThat(result).isEqualTo(15);
    }

    @Test
    @Tag("ParkingSpotsForBike")
    void bikeSpotsMustBeBetween1And10() {
        parkingUnderTest.setBikeSpot(0);
        final int testLessThan1 = parkingUnderTest.getBikeSpot();
        assertThat(testLessThan1).isBetween(1, 10);

        parkingUnderTest.setBikeSpot(11);
        final int testMoreThan10 = parkingUnderTest.getBikeSpot();
        assertThat(testMoreThan10).isBetween(1, 10);
    }

    @RepeatedTest(value = 10, name = "repeatedTestBikeSportMustBetween1And10 {currentRepetition}/{totalRepetitions}")
    @Tag("ParkingSpotsForBike")
    void repeatedTestBikeSportMustBetween1And10(){
        parkingUnderTest.defineNumberBikesSpot();
        assertThat(parkingUnderTest.getBikeSpot()).isBetween(1, 10);
    }

    @Test
    void ShouldReturnNumberDesignedByParameters(){
        parkingUnderTest.addVehicle(car);
        parkingUnderTest.addVehicle(moto);
        parkingUnderTest.addVehicle(moto);
        parkingUnderTest.addVehicle(bike);
        parkingUnderTest.addVehicle(bike);
        parkingUnderTest.addVehicle(bike);

        int result = parkingUnderTest.numberOfThisTypeVehicle("moto");
        assertThat(result).isEqualTo(2);
    }
}
