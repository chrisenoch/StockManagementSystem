package com.chris.enoch.shoeshop.entity;

import java.util.List;

/**
 * Returns a result object which holds details of whether the operation was successful and details of any error messages.
 * There are many reasons why a stock order could be denied. This class encapsulates all of the messages
 * that detail why a stock order is denied along with a boolean isStockOrderSuccesful indicating if the operation was a success 
 * or not.
 * @author chris
 *
 */
public class OrderStockFeedback {
	private List<String>errorMessages; ;
	private boolean isStockOrderSuccesful;
	
	public OrderStockFeedback(List<String> errorMessages, boolean isStockOrderSuccesful) {
		super();
		this.errorMessages = errorMessages;
		this.isStockOrderSuccesful = isStockOrderSuccesful;
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}	
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public boolean isStockOrderSuccesful() {
		return isStockOrderSuccesful;
	}
	public void setStockOrderSuccesful(boolean isStockOrderSuccesful) {
		this.isStockOrderSuccesful = isStockOrderSuccesful;
	}
	
	
	
	

}
