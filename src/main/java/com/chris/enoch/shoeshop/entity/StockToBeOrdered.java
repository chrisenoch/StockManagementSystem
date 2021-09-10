package com.chris.enoch.shoeshop.entity;
import java.util.ArrayList;
import java.util.List;
 
public abstract class StockToBeOrdered {
	protected List<Shoe> stockToBeOrdered = new ArrayList<>();
	protected Shoe shoeToOrder;
	protected int numberPairsShoesToOrder;

	public StockToBeOrdered(List<Shoe> stockToBeOrdered, Shoe shoeToOrder) {
		super();
		this.stockToBeOrdered = stockToBeOrdered;
		this.shoeToOrder = shoeToOrder;
	
	}

	public List<Shoe> getStockToBeOrdered() {
		return stockToBeOrdered;
	}

	public void setStockToBeOrdered(List<Shoe> stockToBeOrdered) {
		this.stockToBeOrdered = stockToBeOrdered;
	}

	public Shoe getShoeToOrder() {
		return shoeToOrder;
	}

	public void setShoeToOrder(Shoe shoeToOrder) {
		this.shoeToOrder = shoeToOrder;
	}

	public int getNumberPairsShoesToOrder() {
		return numberPairsShoesToOrder;
	}

	public void setNumberPairsShoesToOrder(int numberPairsShoesToOrder) {
		this.numberPairsShoesToOrder = numberPairsShoesToOrder;
	}

	//Add List<Shoe> shoes argument here?
	public OrderStockFeedback addStockToBeOrdered() {
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true); //setStockOrderSuccesful to true initially 
		
				
		OrderStockFeedback checkStockToBeOrdered = checkStockToBeOrdered();
		if (!checkStockToBeOrdered.isStockOrderSuccesful()) {   
			orderStockFeedback.setStockOrderSuccesful(false);		
			orderStockFeedback.setErrorMessages(checkStockToBeOrdered.getErrorMessages());
		} else {
			for (int i = 0; i < numberPairsShoesToOrder; i++) {
				stockToBeOrdered.add(shoeToOrder);
			}
		}
		
		
		return orderStockFeedback;
	}
	
	protected abstract OrderStockFeedback checkStockToBeOrdered();
	
	//returns number reduced by
	//protected abstract int reduceStock(Shoe shoe, int num) throws Exception;
	
	//To do //returns number added, or - number to show how many too many you tried to reduce
	//protected abstract int addStock(Shoe shoe, int num);
		

}
