package com.aiatss.OOCamp;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParkingBoy {
	List<Park> parks;

	public AbstractParkingBoy(Park ... parks) {
		this.parks = Arrays.asList(parks);
	}

	public Token park(Car car) {
		Park availablePark = getLastAvailablePark();
		return availablePark.parkOneCar(car);
	}

	protected abstract Park getLastAvailablePark() ;

	public Car pick(Token token) {
		Park parkWhereCarIsIn = searchParkByToken(token);
		return parkWhereCarIsIn.getOneCar(token);
	}

	private Park searchParkByToken(Token token) {
		for(Park park : parks) {
			if (park.hasCar(token)) {
				return park;
			}
		}
		return Park.NULLPARK;
	}
}
