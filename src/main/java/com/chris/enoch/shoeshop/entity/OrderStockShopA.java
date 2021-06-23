package com.chris.enoch.shoeshop.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chris.enoch.shoeshop.exceptions.TooManyTypesOfShoesException;
import com.chris.enoch.shoeshop.exceptions.TooMuchStockException;

public class OrderStockShopA extends OrderStock{
	
	private List<Shoe> stockList;
	private Shoe shoeToOrder;
	private int numberPairsShoesToOrder;
	private int maxStockWeCanHold;
	private int maxShoeTypes;


	@Override
	protected OrderStockFeedback checkStock(List<Shoe> shoes) {
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true);
		
		try {
			checkStockOrderNotTooHigh();
		} catch (TooMuchStockException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			maxShoeTypes();
		} catch (TooManyTypesOfShoesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected OrderStockFeedback informSupplierOfStockOrder() {
		OrderStockFeedback orderStockFeedback = new OrderStockFeedback(new ArrayList<>(), true);
		
		//Logic for informing suppliuer here.
		//For now, just return successfully with no errors
		
		return orderStockFeedback;
	}
	
	private void checkStockOrderNotTooHigh() throws TooMuchStockException {
		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stockList);
		for (int i = 0; i < numberPairsShoesToOrder; i++) {
			tempShoes.add(shoeToOrder);
		}
		
		if (tempShoes.size() > maxStockWeCanHold) {
			throw new TooMuchStockException("Total stock would be " + tempShoes.size() +  " "
					+ "with this order. The warehouse can only hold " + maxStockWeCanHold + " pairs of shoes. Stock not added.");
		}
		//return tempShoes.size() <= 500;
	}
	
	//Changed from 200 to 10, for ease of testing.
	private void maxShoeTypes() throws TooManyTypesOfShoesException {

		//create temp list so object references do not modify original stockList
		List<Shoe> tempShoes = new ArrayList<>(stockList);
		for (int i = 0; i < numberPairsShoesToOrder; i++) {
			tempShoes.add(shoeToOrder);
		}
		
		if (tempShoes.size() <= maxShoeTypes) {
			return;
		}
		
		Set<ShoeType> numOfShoeTypes = new HashSet<>();
		
		for (int i = 1; i < tempShoes.size();i ++) { //start iterating from second in the list
				numOfShoeTypes.add(tempShoes.get(i).getShoeType());
				
				if (numOfShoeTypes.size() > maxShoeTypes) {
					throw new TooManyTypesOfShoesException("With this order we would have more than " +maxShoeTypes
							+ " types of shoes. We can only hold " + maxShoeTypes + " types.");
				}			
		}	
		
	}
	

}
