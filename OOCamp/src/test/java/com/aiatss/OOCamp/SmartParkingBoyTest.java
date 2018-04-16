package com.aiatss.OOCamp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmartParkingBoyTest {
	
	@Test
	public void should_be_able_to_park_to_the_first_park_when_it_is_not_full() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy abstractParkingBoy = new ParkingBoy(new SmartParkingBoyStrategy(), park1, park2);

		abstractParkingBoy.park(new Car());

		assertEquals(1, park2.getAvailableParkingLot());
	}

	@Test
	public void should_be_able_to_park_to_the_second_park_when_the_first_is_full() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy abstractParkingBoy = new ParkingBoy(new SmartParkingBoyStrategy(), park1, park2);
		abstractParkingBoy.park(new Car());
		
		abstractParkingBoy.park(new Car());

		assertEquals(1, park2.getAvailableParkingLot());
	}
}
