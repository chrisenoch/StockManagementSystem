package com.chris.enoch.shoeshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentStock {
	List<Shoe> stockList;
	
	public CurrentStock(List<Shoe> stockList) {
		super();
		this.stockList = stockList;
	}

	public List<Shoe> getStockList() {
		return stockList;
	}

	public void setStockList(List<Shoe> stockList) {
		this.stockList = stockList;
	}

	public int reduceStock(Shoe shoe, int amountRequested) throws Exception {
		checkReduceStock(shoe, amountRequested);
		
		//This will be changed to call a dao method.
		for (int i = 0; i < amountRequested; i++ ) {
			stockList.remove(shoe);
		}	
		return amountRequested;
	}
	
	private void checkReduceStock(Shoe shoe, int amountRequested) throws Exception {
		//CHECK IF IN STOCK
			//tempList so do not modify list in object
		List<Shoe> tempList = new ArrayList<>(stockList); //all types of shoes
		//get just type of shoes customer wants
		List<Shoe> shoesSelectedByCustomer = tempList.stream()
				.filter(s -> s.equals(shoe)).collect(Collectors.toList());
			
		if (shoesSelectedByCustomer.size() == 0) {
			throw new Exception("Sorry, we do not have those types of shoes in stock.");
		}
		
		if (amountRequested > shoesSelectedByCustomer.size()) {
			int itemsTooMany = amountRequested - shoesSelectedByCustomer.size();
			throw new Exception("Sorry, you requested " + itemsTooMany + " pairs too many. We only have "
					+ shoesSelectedByCustomer.size() + " pairs of those shoes in stock");
		}
	}

}
