package com.aiatss.OOCamp;

public class ParkingBoy extends AbstractParkingBoy{
	
	public ParkingBoy(Park park1, Park park2) {
		super(park1, park2);
	}

	@Override
	protected Park getLastAvailablePark() {
		for(Park park : parks) {
			if (park.isAvailable()) {
				return park;
			}
		}
		return Park.NULLPARK;
	}
}
