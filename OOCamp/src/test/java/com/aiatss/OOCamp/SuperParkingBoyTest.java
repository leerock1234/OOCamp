package com.aiatss.OOCamp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuperParkingBoyTest {

	@Test
	public void should_be_able_to_park_to_the_first_park_when_it_is_not_full() {
		Park park1 = new Park(10);
		parkCar(park1);
		Park park2 = new Park(20);
		ParkingBoy SuperParkingBoy = new ParkingBoy(new SuperParkingBoyStrategy(), park1, park2);

		SuperParkingBoy.park(new Car());

		assertEquals(9, park1.getAvailableParkingLot());
		assertEquals(19, park2.getAvailableParkingLot());
	}

	@Test
	public void should_be_able_to_park_to_the_second_park_when_the_first_is_full() {
		Park park1 = new Park(10);
		Park park2 = new Park(20);
		parkCar(park2);
		ParkingBoy superParkingBoy = new ParkingBoy(new SuperParkingBoyStrategy(), park1, park2);
		
		superParkingBoy.park(new Car());

		assertEquals(9, park1.getAvailableParkingLot());
		assertEquals(19, park2.getAvailableParkingLot());
	}

	private void parkCar(Park park2) {
		park2.parkOneCar(new Car());
	}

	private void parkCar(Park park2, int count) {
		for(int i=0; i<count; i++) {
			park2.parkOneCar(new Car());
		}
	}
	
}
