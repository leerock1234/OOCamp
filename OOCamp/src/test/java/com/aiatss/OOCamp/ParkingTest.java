package com.aiatss.OOCamp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ParkingTest {
	
	@Test
	public void should_be_able_to_park_when_there_is_available_park(){
		Park park = new Park(2);
		
		Token token = park.parkOneCar(new Car());
		
		assertNotNull(token);
	}
	
	@Test
	public void should_not_be_able_to_park_when_there_is_no_available_park(){
		Park park = new Park(0);
		
		try{
			park.parkOneCar(new Car());
		}catch(NoParkLotException e){
			return;
		}
		fail();
	}
	
}
