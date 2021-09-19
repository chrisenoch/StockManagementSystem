package com.chris.enoch.shoeshop.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A new instance of StockToBeOrdered is needed for each stock order.
 */
public abstract class StockToBeOrdered {
	protected List<Shoe> stockToBeOrdered = new ArrayList<>();
	protected Shoe shoeToOrder;
	protected int numberPairsShoesToOrder;
	protected CurrentStock currentStock;
	protected LocalDateTime dateAdded;

	public StockToBeOrdered(Shoe shoeToOrder, CurrentStock currentStock, LocalDateTime dateAdded) {
		super();
		this.shoeToOrder = shoeToOrder;
		this.currentStock = currentStock;
		this.dateAdded = dateAdded;
	
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

	public CurrentStock getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(CurrentStock currentStock) {
		this.currentStock = currentStock;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 *Adds stock if no error messages are present or else sets appropriate error messages.
	 * @return OrderStockFeedback object detailing the success status and any relevant error messages in case of failure.
	 */
	public final OrderStockFeedback addStockToBeOrdered() {
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
	
	/**
	 * Runs the necessary checks before a batch of stock is ordered. No parameters are specified because each shop may check different
	 * things and hence need different parameters. For instance, Shop A may check that they don't order Men's shoes, while Shop B
	 * may check that no more than X types of shoes are ordered. The parameters can be set as instance variables of the subclasses and accessed from the 
	 * method.
	 * @return
	 */
	protected abstract OrderStockFeedback checkStockToBeOrdered();
	


}
