package com.aiatss.OOCamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AbstractParkingBoyTest {

	String className;

	public AbstractParkingBoyTest(String className) {
		this.className = className;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[] { "ParkingBoy", "SmartParkingBoy", "SuperParkingBoy" });
	}

	@Test
	public void should_be_able_to_employ_a_new_parking_boy_with_2_parking_lots() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		createParkingBoy(park1, park2);
	}
	
	private ParkingBoy createParkingBoy(Park park1, Park park2) {
		if (className.equals("ParkingBoy")) {
			return new ParkingBoy(new ParkingBoyStrategy(), park1, park2);
		}
		if (className.equals("SmartParkingBoy")) {
			return new ParkingBoy(new SmartParkingBoyStrategy(), park1, park2);
		}
		if (className.equals("SuperParkingBoy")) {
			return new ParkingBoy(new SuperParkingBoyStrategy(), park1, park2);
		}
		return null;
	}

	@Test(expected = NoParkLotException.class)
	public void should_fail_when_there_is_no_available_parking_lot() {
		ParkingBoy parkingBoy = employParkingBoyWithTwoParks();
		parkingBoy.park(new Car());
		parkingBoy.park(new Car());
		parkingBoy.park(new Car());
		
		parkingBoy.park(new Car());
	}

	@Test
	public void should_be_able_to_get_car_in_the_first_parking_lot() {
		ParkingBoy parkingBoy = employParkingBoyWithTwoParks();
		Car car = new Car();
		Token token = parkingBoy.park(car);
		parkingBoy.park(new Car());
		parkingBoy.park(new Car());
		
		Car pickedCar = parkingBoy.pick(token);
		assertSame(car, pickedCar);
	}

	@Test
	public void should_be_able_to_get_car_in_the_second_parking_lot() {
		ParkingBoy parkingBoy = employParkingBoyWithTwoParks();
		parkingBoy.park(new Car());
		Car car = new Car();
		Token token = parkingBoy.park(car);
		parkingBoy.park(new Car());
		
		Car pickedCar = parkingBoy.pick(token);
		assertSame(car, pickedCar);
	}

	@Test(expected = NoCarFoundException.class)
	public void should_fail_to_get_an_non_existed_car() {
		ParkingBoy parkingBoy = employParkingBoyWithTwoParks();
		Car car = new Car();
		Token token = parkingBoy.park(car);
		parkingBoy.pick(token);

		parkingBoy.pick(token);
	}
	
	@Test
	public void should_reuse_parking_lot() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy parkingBoy = createParkingBoy(park1, park2);
		Car car = new Car();
		Token token = parkingBoy.park(car);
		parkingBoy.park(new Car());
		parkingBoy.pick(token);
		
		parkingBoy.park(new Car());
		assertEquals(0, park1.getAvailableParkingLot());
		assertEquals(1, park2.getAvailableParkingLot());
	}

	private ParkingBoy employParkingBoyWithTwoParks() {
		Park park1 = new Park(1);
		Park park2 = new Park(2);
		ParkingBoy parkingBoy = createParkingBoy(park1, park2);
		return parkingBoy;
	}

}
