package com.chris.enoch.shoeshop.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.chris.enoch.shoeshop.exceptions.TooManyTypesOfShoesException;
import com.chris.enoch.shoeshop.exceptions.TooMuchStockException;

public class StockToBeOrderedShopA extends StockToBeOrdered{
	
	private Stock stock;
	private int maxStockWeCanHold;
	private int maxNumOfShoeTypes;

	public StockToBeOrderedShopA(List<Shoe> stockToBeOrdered, Stock stock, Shoe shoeToOrder, int numberPairsShoesToOrder,
			 int maxStockWeCanHold, int maxNumOfShoeTypes) {
		super(stockToBeOrdered, shoeToOrder, numberPairsShoesToOrder);
		this.stock = stock;
		this.maxStockWeCanHold = maxStockWeCanHold;
		this.maxNumOfShoeTypes = maxNumOfShoeTypes;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
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

	public int getMaxStockWeCanHold() {
		return maxStockWeCanHold;
	}

	public void setMaxStockWeCanHold(int maxStockWeCanHold) {
		this.maxStockWeCanHold = maxStockWeCanHold;
	}

	public int getMaxNumOfShoeTypes() {
		return maxNumOfShoeTypes;
	}

	public void setMaxNumOfShoeTypes(int maxNumOfShoeTypes) {
		this.maxNumOfShoeTypes = maxNumOfShoeTypes;
	}



	@Override
	protected OrderStockFeedback checkStockToBeOrdered() {
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true);
		List<String> errors = new ArrayList<>();
		
		OrderStockFeedback checkStockOrderNotTooHigh = checkStockOrderNotTooHigh();
		OrderStockFeedback maxShoeTypes = checkMaxNumOfShoeTypes();
		
		//Set as false if checkStockOrderNotTooHigh# or maxShoeTypes# failed.
		if (!checkStockOrderNotTooHigh.isStockOrderSuccesful()) {
			orderStockFeedback .setStockOrderSuccesful(false);
		}
		if (!maxShoeTypes.isStockOrderSuccesful()) {
			orderStockFeedback .setStockOrderSuccesful(false);
		}
		
		if (!orderStockFeedback.isStockOrderSuccesful()) {
			//Set error messages
			errors.addAll(checkStockOrderNotTooHigh.getErrorMessages());
			errors.addAll(maxShoeTypes.getErrorMessages());
			//Add to OrderStockFeedback
			orderStockFeedback.setErrorMessages(errors);
			
		}
//		} else {
//			
//			//Add to stockToBeOrdered list - For now overwrite existing values. Later change so warns user that there is already shoes of this type scheduled to be ordered.
//			stockToBeOrdered.put(shoeToOrder, numberPairsShoesToOrder);	
//			
//		}
//		
		return orderStockFeedback;
	}

	
	private OrderStockFeedback checkStockOrderNotTooHigh() {
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true);
		List<String> errors = new ArrayList<>();
		
		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stock.getStockList());
		for (int i = 0; i < numberPairsShoesToOrder; i++) {
			tempShoes.add(shoeToOrder);
		}
		
		//Combine StockToBeOrdered and Stock lists
		tempShoes.addAll(stockToBeOrdered);
		
		if (tempShoes.size() > maxStockWeCanHold) {
			orderStockFeedback.setStockOrderSuccesful(false);
			errors.add("Total stock + stock waiting to be ordered would be " + tempShoes.size() +  " "
					+ "with this order. The warehouse can only hold " + maxStockWeCanHold + " pairs of shoes. Stock not added.");
			orderStockFeedback.setErrorMessages(errors);
		}
		return orderStockFeedback;
	}
	

	private OrderStockFeedback checkMaxNumOfShoeTypes() {
		
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true);
		List<String> errors = new ArrayList<>();

		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stock.getStockList());
		for (int i = 0; i < numberPairsShoesToOrder; i++) {
			tempShoes.add(shoeToOrder);
		}
		
		//Combine StockToBeOrdered and Stock lists
		tempShoes.addAll(stockToBeOrdered);
		
		if (tempShoes.size() <= maxNumOfShoeTypes) {
			return orderStockFeedback;
		}
		
		Set<ShoeType> numOfShoeTypes = new HashSet<>();
		
		for (int i = 1; i < tempShoes.size();i ++) { //start iterating from second in the list
				numOfShoeTypes.add(tempShoes.get(i).getShoeType());
				
				if (numOfShoeTypes.size() > maxNumOfShoeTypes) {
					orderStockFeedback.setStockOrderSuccesful(false);
					
				}			
		}	
		
		if (!orderStockFeedback.isStockOrderSuccesful()) {
			errors.add("With this order we would have more than " +maxNumOfShoeTypes
					+ " types of shoes in stock and stock waiting to be ordered. We can only hold " + maxNumOfShoeTypes + " types.");
			orderStockFeedback.setErrorMessages(errors);
		}
		
		return orderStockFeedback;
		
	}
	

}
