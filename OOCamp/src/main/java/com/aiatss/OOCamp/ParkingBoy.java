package com.aiatss.OOCamp;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
	List<Park> parks;
	ChooseParkStrategy chooseParkStrategy;

	public ParkingBoy(ChooseParkStrategy chooseParkStrategy, Park ... parks) {
		this.chooseParkStrategy = chooseParkStrategy;
		this.parks = Arrays.asList(parks);
	}

	public Token park(Car car) {
		Park availablePark = choosePark();
		return availablePark.parkOneCar(car);
	}

	Park choosePark() {
		return chooseParkStrategy.choosePark(parks);
	}

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
