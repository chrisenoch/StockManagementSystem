package com.chris.enoch.shoeshop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.chris.enoch.shoeshop.entity.Shoe;
import com.chris.enoch.shoeshop.entity.ShoeType;
import com.chris.enoch.shoeshop.exceptions.TooManyTypesOfShoesException;
import com.chris.enoch.shoeshop.exceptions.TooMuchStockException;

//shoes, 200 types max
//500 store max
//customer needs to get footwear by footwear and amount
//start off with zero in stock

public class LoliShoeShop {
	
	private List<Shoe> stockList = new ArrayList<>();
	
	public List<Shoe> getStockList() {
		return stockList;
	}

	public void setStockList(List<Shoe> shoes) {
		this.stockList = shoes;
	}

	public void orderStock(Shoe shoe, int amount) throws TooManyTypesOfShoesException, TooMuchStockException {
			stockLessThanOrEqualTo500(shoe, amount);
			stockListContainsLessThanOrEqualTo10Types(shoe, amount); //Changed from 200 to 10 to make testing easier in App class.	
			
			//Add stock to stock list
			for (int i = 0; i < amount; i++) {
				stockList.add(shoe);
			}		 
	}
	

	public void buyShoes(Shoe shoe, int amountRequested) throws Exception {
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
		
		//If get to here, no problems with order
		//discount from the stock list
		for (int i = 0; i < amountRequested; i++ ) {
			stockList.remove(shoe);
		}
			
	}
	

	private void stockLessThanOrEqualTo500(Shoe shoe, int amount) throws TooMuchStockException {
		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stockList);
		for (int i = 0; i < amount; i++) {
			tempShoes.add(shoe);
		}
		
		if (tempShoes.size() > 500) {
			throw new TooMuchStockException("Total stock would be " + tempShoes.size() +  " "
					+ "with this order. The warehouse can only hold 500 pairs of shoes. Stock not added.");
		}
		//return tempShoes.size() <= 500;
	}
	
	//Changed from 200 to 10, for ease of testing.
	private void stockListContainsLessThanOrEqualTo10Types(Shoe shoe, int amount) throws TooManyTypesOfShoesException {

		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stockList);
		for (int i = 0; i < amount; i++) {
			tempShoes.add(shoe);
		}
		
		if (tempShoes.size() <= 10) {
			return;
		}
		
		Set<ShoeType> numOfShoeTypes = new HashSet<>();
		
		for (int i = 1; i < tempShoes.size();i ++) { //start iterating from second in the list
				numOfShoeTypes.add(tempShoes.get(i).getShoeType());
				
				if (numOfShoeTypes.size() > 10) {
					throw new TooManyTypesOfShoesException("With this order we would have more than 10 "
							+ "types of shoes. We can only hold 10 types.");
					//Changed from 200 to 10 for ease of testing in App class.
				}			
		}	
		
	}
	
}



