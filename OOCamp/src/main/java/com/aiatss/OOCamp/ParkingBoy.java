package com.aiatss.OOCamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
	List<Park> parks;
	ChooseParkStrategy chooseParkStrategy;

	private ParkingBoy(ChooseParkStrategy chooseParkStrategy, Park ... parks) {
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

	public static ParkingBoy createSuperParkingBoy(Park ... park) {
		return new ParkingBoy(new SuperParkingBoyStrategy(), park);
	}

	public static ParkingBoy createSmartParkingBoy(Park ... park) {
		return new ParkingBoy(new SmartParkingBoyStrategy(), park);
	}

	public static ParkingBoy createParkingBoy(Park ... park) {
		return new ParkingBoy(new ParkingBoyStrategy(), park);
	}

	public static ParkingBoy createParkingManager(ParkingBoy ... boys) {
		Park[] parks = getParksFromBoys(boys);
		return new ParkingBoy(new ParkingBoyStrategy(), parks);
	}

	private static Park[] getParksFromBoys(ParkingBoy[] boys) {
		List<Park> parks = new ArrayList<>();
		for(ParkingBoy boy : boys){
			parks.addAll(boy.parks);
		}
		return parks.toArray(new Park[]{});
	}
}
