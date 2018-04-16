package com.aiatss.OOCamp;

import java.util.List;

public class SuperParkingBoyStrategy implements ChooseParkStrategy{

	@Override
	public Park choosePark(List<Park> parks) {
		Park parkReturn=Park.NULLPARK;
		for(Park park : parks) {
			if ((park.getAvailableRate() - parkReturn.getAvailableRate()) > 0) {
				parkReturn = park;
			}
		}
		return parkReturn;
	}

}
