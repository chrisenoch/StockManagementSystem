package com.chris.enoch.shoeshop.entity;

import java.util.stream.Collectors;

public class StockToBeOrderedUtils {
	
	/**
	 * A convenience method for setting the variables needed for the overridden version of
	 * {@link StockToBeOrdered#checkStockToBeOrdered()} to work. 
	 * In addition, it defines how success/error messages are to be displayed. Each shoe shop can either use this method or create their own 
	 * convenience method if their version of {@link StockToBeOrdered#checkStockToBeOrdered()} takes different parameters.
	 * @param stockToBeOrdered
	 * @param shoeToOrder
	 * @param numberPairsShoesToOrder
	 * @return A success or failure message
	 */
	public static String addAndGetFeedback(StockToBeOrdered stockToBeOrdered, Shoe shoeToOrder, int numberPairsShoesToOrder) {
		stockToBeOrdered.setShoeToOrder(shoeToOrder);
		stockToBeOrdered.setNumberPairsShoesToOrder(numberPairsShoesToOrder);
		OrderStockFeedback orderStockFeedback = stockToBeOrdered.addStockToBeOrdered();
		
		if (!orderStockFeedback.isStockOrderSuccesful()) {
			return orderStockFeedback.getErrorMessages().stream().collect(Collectors.joining(", "));
		} else {
			return "Successfully added " + numberPairsShoesToOrder +" pairs of " + shoeToOrder.getName();
		}
	
	}

}
