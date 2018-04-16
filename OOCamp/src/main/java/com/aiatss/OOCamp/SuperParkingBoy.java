package com.aiatss.OOCamp;

public class SuperParkingBoy extends AbstractParkingBoy {

	public SuperParkingBoy(Park park1, Park park2) {
		super(park1, park2);
	}

	@Override
	protected Park getLastAvailablePark() {
		Park parkReturn=Park.NULLPARK;
		for(Park park : parks) {
			if ((park.getAvailableRate() - parkReturn.getAvailableRate()) > 0) {
				parkReturn = park;
			}
		}
		return parkReturn;
	}
}
