package com.aiatss.OOCamp;

import java.util.List;

public class ParkingBoyStrategy implements ChooseParkStrategy{

	@Override
	public Park choosePark(List<Park> parks) {
		for(Park park : parks) {
			if (park.isAvailable()) {
				return park;
			}
		}
		return Park.NULLPARK;
	}

}
