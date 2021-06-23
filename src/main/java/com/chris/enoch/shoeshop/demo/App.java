package com.chris.enoch.shoeshop.demo;

import com.chris.enoch.shoeshop.LoliShoeShop;
import com.chris.enoch.shoeshop.entity.Address;
import com.chris.enoch.shoeshop.entity.Shoe;
import com.chris.enoch.shoeshop.entity.ShoeType;
import com.chris.enoch.shoeshop.entity.Supplier;
import com.chris.enoch.shoeshop.exceptions.TooManyTypesOfShoesException;
import com.chris.enoch.shoeshop.exceptions.TooMuchStockException;

public class App {
	public static void main(String[] args) {
		//Init addresses
		
		Address nikeAddress = new Address(1, (short)14, "Paul Street", "Harbourne", "Birmingham"
				, "England", "B62 0GF", "01214507656");
		Address doctorMartinsAddress = new Address(12, (short)142, "Lavina Road", "Smethick"
				, "Birmingham", "England", "B63 0GR", "01214506759");
		Address vansAddress = new Address(12, (short)142, "John Road", "Lapal", "Birmingham"
				, "England", "B64 0QW", "01214233243");
		
		//Init suppliers
		Supplier nikeSupplier = new Supplier(0, nikeAddress);
		Supplier doctorMartinsSupplier = new Supplier(1, doctorMartinsAddress);
		Supplier vansSupplier = new Supplier(2, vansAddress);
		
		//Init shoes - Improve variable names			
		Shoe trainer = new Shoe(0, 0, nikeSupplier, ShoeType.RUNNING, 8000);	
		Shoe flipFlops = new Shoe(1, 1, vansSupplier, ShoeType.BEACH, 5000);
		Shoe hikingBoots = new Shoe(2, 2, doctorMartinsSupplier, ShoeType.MILITARY, 9000);
		Shoe nikeAirtrainerShoe = new Shoe(3,  3, nikeSupplier, ShoeType.SNEAKER, 11000);
		Shoe leatherbootsVans = new Shoe(4,  4, vansSupplier, ShoeType.LEATHER_BOOTS, 1200);
		Shoe r9s = new Shoe(5,  5, nikeSupplier, ShoeType.FOOTBALL_BOOTS, 15000);
		Shoe balletShoes = new Shoe(5,  5, vansSupplier, ShoeType.DANCING, 8000);
		Shoe sandals = new Shoe(6,  6, vansSupplier, ShoeType.WEDDING, 20000);
		Shoe rugbyNike = new Shoe(7,  7, nikeSupplier, ShoeType.RUGBY, 8000);
		Shoe wellies = new Shoe(8,  8, doctorMartinsSupplier, ShoeType.WELLIES, 5000);
		Shoe slippers = new Shoe(9,  9, doctorMartinsSupplier, ShoeType.SLIPPERS, 2000);

		LoliShoeShop loliShoeShop = new LoliShoeShop();
		
		//Test stockLessThanOrEqualTo500#
		try {
			loliShoeShop.orderStock(trainer, 400);
			loliShoeShop.orderStock(trainer, 110);
		} catch (TooManyTypesOfShoesException | TooMuchStockException e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}	
		
		System.out.println("Should be 400: " + loliShoeShop.getStockList().size()); //Should be 400
		
		//Test stockLessThanOrEqualTo500#
		//Should work
		try {
			loliShoeShop.orderStock(flipFlops, 1);
			loliShoeShop.orderStock(hikingBoots, 1);
			loliShoeShop.orderStock(nikeAirtrainerShoe , 1);
			loliShoeShop.orderStock(leatherbootsVans, 1);
			loliShoeShop.orderStock(r9s, 1);
			loliShoeShop.orderStock(balletShoes, 1);
			loliShoeShop.orderStock(sandals, 1);
			loliShoeShop.orderStock(slippers, 1);
			loliShoeShop.orderStock(wellies, 10);	

		} catch (TooManyTypesOfShoesException | TooMuchStockException e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}	
		System.out.println("Should be 418: " + loliShoeShop.getStockList().size()); //Should be 418

		//Should throw exception as is the 11th type of shoe to be added and only 10 types allowed.
		try {	
			loliShoeShop.orderStock(rugbyNike, 1);

		} catch (TooManyTypesOfShoesException | TooMuchStockException e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
		System.out.println("Should be 418: " +  loliShoeShop.getStockList().size()); //Should be 418
		
		
		//Test buyShoes#
		//Should work
		try {
			loliShoeShop.buyShoes(wellies, 10);
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
		System.out.println("Should be 408: " + loliShoeShop.getStockList().size()); //Should be 408
		
		//Should fail as only 10 pairs of wellies in stock
		try {
			loliShoeShop.buyShoes(wellies, 1);
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
		System.out.println("Should be 408: " + loliShoeShop.getStockList().size()); //Should be 408
		

	}

}
