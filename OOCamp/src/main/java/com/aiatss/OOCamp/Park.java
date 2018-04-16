package com.aiatss.OOCamp;

import java.util.HashMap;
import java.util.Map;

public class Park {
	
	public static Park NULLPARK = new Park(0);

	private int totalParkingLot;
	Map<Token, Car> cars = new HashMap<>();
	
	public Park(int totalParkingLot) {
		this.totalParkingLot = totalParkingLot;
	}

	public Token parkOneCar(Car car) {
		if (getAvailableParkingLot() == 0) {
			throw new NoParkLotException();
		}
		Token tokenGenerated = new Token();
		cars.put(tokenGenerated, car);
		return tokenGenerated;
	}

	public int getAvailableParkingLot() {
		return totalParkingLot - cars.size();
	}
	
	boolean isAvailable() {
		return getAvailableParkingLot() > 0;
	}

	public Car getOneCar(Token token) {
		Car car = cars.remove(token);
		if (car == null) {
			throw new NoCarFoundException();
		}
		return car;
	}

	public boolean hasCar(Token token) {
		return cars.containsKey(token);
	}

	public double getAvailableRate() {
		if (totalParkingLot==0) {
			return 0;
		}
		return (double) this.getAvailableParkingLot() / totalParkingLot;
	}

}
