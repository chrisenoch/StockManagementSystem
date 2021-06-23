package com.chris.enoch.shoeshop.entity;
import java.util.ArrayList;
import java.util.List;
 
public abstract class OrderStock {
	
	protected OrderStockFeedback orderStock(List<Shoe> shoes) {
		boolean successfulOrder = true;
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), successfulOrder);
		List<Shoe> stockToBeOrderedList;
		
		//List<String> errorMessages = orderStockFeedback.getErrorMessages();
				
		OrderStockFeedback checkStock = checkStock(shoes);
		if (!checkStock.isStockOrderSuccesful()) {
			successfulOrder = false;      
			orderStockFeedback.setErrorMessages(checkStock.getErrorMessages());
		}
		
		OrderStockFeedback orderStock = informSupplierOfStockOrder();
		if (!orderStock .isStockOrderSuccesful()) {
			successfulOrder = false;  
			orderStockFeedback.getErrorMessages().addAll(orderStock.getErrorMessages());		
		}
		
		if (successfulOrder) {
			orderStockFeedback.setStockOrderSuccesful(true);
		} else {
			orderStockFeedback.setStockOrderSuccesful(false);
		}
		
		return orderStockFeedback;
	}
	
	protected abstract OrderStockFeedback checkStock(List<Shoe> shoes);
	
	protected abstract OrderStockFeedback informSupplierOfStockOrder();
		

}
