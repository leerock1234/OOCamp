package com.aiatss.OOCamp;

import java.util.List;

public class SmartParkingBoyStrategy implements ChooseParkStrategy{

	@Override
	public Park choosePark(List<Park> parks) {
		Park parkReturn=Park.NULLPARK;
		for(Park park : parks) {
			if (park.getAvailableParkingLot() > parkReturn.getAvailableParkingLot()) {
				parkReturn = park;
			}
		}
		return parkReturn;
	}

}
