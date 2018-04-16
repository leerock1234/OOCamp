package com.aiatss.OOCamp;

import static org.junit.Assert.assertSame;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GetCarTest {
	
	@Test
	public void should_be_able_to_get_car_when_there_is_car_in_parking_with_correct_no(){
		Park park = new Park(1);
		Car car = new Car();
		Token token = park.parkOneCar(car);
		
		Car carPicked = park.getOneCar(token);
		
		assertSame(car, carPicked);
	}
	
	@Rule public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void should_not_be_able_to_get_car_when_there_is_no_car_in_parking_with_wrong_no(){
		Park park = new Park(1);
		park.parkOneCar(new Car());
		expectedEx.expect(NoCarFoundException.class);

		park.getOneCar(new Token());
	}

	@Test
	public void should_not_be_able_to_get_car_twice(){
		Park park = new Park(1);
		Token token = park.parkOneCar(new Car());
		park.getOneCar(token);
		expectedEx.expect(NoCarFoundException.class);

		park.getOneCar(token);
	}
	
}
