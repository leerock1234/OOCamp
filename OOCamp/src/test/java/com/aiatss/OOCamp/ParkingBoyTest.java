package com.aiatss.OOCamp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParkingBoyTest {
	
	@Test
	public void should_be_able_to_park_to_the_first_park_when_it_is_not_full() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy parkingBoy = new ParkingBoy(park1, park2);

		parkingBoy.park(new Car());

		assertEquals(0, park1.getAvailableParkingLot());
	}

	@Test
	public void should_be_able_to_park_to_the_second_park_when_the_first_is_full() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy parkingBoy = new ParkingBoy(park1, park2);
		parkingBoy.park(new Car());
		
		parkingBoy.park(new Car());

		assertEquals(1, park2.getAvailableParkingLot());
	}
}
