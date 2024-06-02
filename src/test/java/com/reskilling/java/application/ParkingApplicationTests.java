package com.reskilling.java.application;

import com.reskilling.java.bean.*;
import com.reskilling.java.utils.ParkingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ParkingApplicationTests {
	@Mock
	Car car;
	@Mock
	Moto moto;
	@Mock
	Bike bike;
	@Mock
	Parking parking;

	ParkingApplication parkingApplication;

	@BeforeEach
	void initParkingApplication(){
		parkingApplication = new ParkingApplication();
	}

	@Test
	@Tag("initParking")
	void initParkingWithMoreThan3parameters(){
		String[] args = {"AXEO", "10", "10", "5"};
		assertThrows(InvalidParameterException.class, () -> {
			ParkingApplication.main(args);
		});
	}
	@Test
	@Tag("initParking")
	void initParkingWithLessThan2parameters(){
		String[] args = {"AXEO"};
		assertThrows(InvalidParameterException.class, () -> {
			ParkingApplication.main(args);
		});
	}

	@Test
	void createNewVehicleWithWrongRandomNumber(){
		MockedStatic<ParkingUtils> parkingUtilsMockedStatic = Mockito.mockStatic(ParkingUtils.class);
		parkingUtilsMockedStatic.when(()->ParkingUtils.generateRandomNumber(any(int.class))).thenReturn(4);
		assertThrows(ClassNotFoundException.class, () -> {
			ParkingApplication.createNewVehicle();
		});
	}
	@Test
	@Tag("addCar")
	void sucessAddCar() {
		when(parking.getCarSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Car")).thenReturn(0);

		parkingApplication.checkEntryParking(car, parking);
		verify(car,times(1)).entreeParking();
		verify(car,times(0)).refusParking();
	}

	@Test
	@Tag("addCar")
	void failAddCar() {
		when(parking.getCarSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Car")).thenReturn(10);

		parkingApplication.checkEntryParking(car, parking);
		verify(car,times(0)).entreeParking();
		verify(car,times(1)).refusParking();
	}

	@Test
	@Tag("addMoto")
	void sucessAddMoto() {
		when(parking.getMotoSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Moto")).thenReturn(0);

		parkingApplication.checkEntryParking(moto, parking);
		verify(moto,times(1)).entreeParking();
		verify(moto,times(0)).refusParking();
	}

	@Test
	@Tag("addMoto")
	void failAddMoto() {
		when(parking.getMotoSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Moto")).thenReturn(10);

		parkingApplication.checkEntryParking(moto, parking);
		verify(moto,times(0)).entreeParking();
		verify(moto,times(1)).refusParking();
	}

	@Test
	@Tag("addBike")
	void sucessAddBike() {
		when(parking.getBikeSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Bike")).thenReturn(0);

		parkingApplication.checkEntryParking(bike, parking);
		verify(bike,times(1)).entreeParking();
		verify(bike,times(0)).refusParking();
	}

	@Test
	@Tag("addBike")
	void failAddBike() {
		when(parking.getBikeSpot()).thenReturn(10);
		when(parking.numberOfThisTypeVehicle("Bike")).thenReturn(10);

		parkingApplication.checkEntryParking(bike, parking);
		verify(bike,times(0)).entreeParking();
		verify(bike,times(1)).refusParking();
	}

	@Test
	void searchNumberAvailableSpotForUnknownVehicle(){
		assertThrows(IllegalArgumentException.class, () -> {
			ParkingApplication.numberAvailableSpot("Unknow", parking);
		});
	}


}
