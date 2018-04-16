package com.aiatss.OOCamp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetParkingLotTest {

	@Test
	public void should_get_the_available_parking_lot_number(){
		Park park = new Park(2);
		park.parkOneCar(new Car());
		
		assertEquals(1, park.getAvailableParkingLot());
	}
}
