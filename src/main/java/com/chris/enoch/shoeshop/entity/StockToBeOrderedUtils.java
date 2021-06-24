package com.chris.enoch.shoeshop.entity;

import java.util.stream.Collectors;

public class StockToBeOrderedUtils {
	
	public static String addAndGetFeedback(StockToBeOrdered stockToBeOrdered, Shoe shoeToOrder, int numberPairsShoesToOrder) {
		stockToBeOrdered.setShoeToOrder(shoeToOrder);
		stockToBeOrdered.setNumberPairsShoesToOrder(numberPairsShoesToOrder);
		OrderStockFeedback oF = stockToBeOrdered.addStockToBeOrdered();
		
		if (!oF.isStockOrderSuccesful()) {
			return oF.getErrorMessages().stream().collect(Collectors.joining(", "));
		} else {
			return "Successfully added " + numberPairsShoesToOrder +" pairs of " + shoeToOrder.getName();
		}
	
	}

}
