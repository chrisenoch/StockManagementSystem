package com.chris.enoch.shoeshop.entity;

import java.util.List;


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
