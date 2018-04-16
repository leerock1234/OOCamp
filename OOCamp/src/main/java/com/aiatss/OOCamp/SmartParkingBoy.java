package com.aiatss.OOCamp;

public class SmartParkingBoy extends AbstractParkingBoy{

	public SmartParkingBoy(Park park1, Park park2) {
		super(park1, park2);
	}
	
	@Override
	protected Park getLastAvailablePark() {
		Park parkReturn=Park.NULLPARK;
		for(Park park : parks) {
			if (park.getAvailableParkingLot() > parkReturn.getAvailableParkingLot()) {
				parkReturn = park;
			}
		}
		return parkReturn;
	}
}
