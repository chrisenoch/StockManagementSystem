package com.chris.enoch.shoeshop.demo;

import static com.chris.enoch.shoeshop.entity.StockToBeOrderedUtils.*;

import java.util.ArrayList;
import java.util.List;

import com.chris.enoch.shoeshop.entity.Address;
import com.chris.enoch.shoeshop.entity.Shoe;
import com.chris.enoch.shoeshop.entity.ShoeType;
import com.chris.enoch.shoeshop.entity.Stock;
import com.chris.enoch.shoeshop.entity.StockToBeOrdered;
import com.chris.enoch.shoeshop.entity.StockToBeOrderedShopA;
import com.chris.enoch.shoeshop.entity.Supplier;

public class App {
	public static void main(String[] args) {
		//Init Stock
		Stock stock = new Stock(new ArrayList<>());
		
		final int MAX_STOCK_CAN_HOLD = 500;
		final int MAX_NUM_OF_SHOE_TYPES = 10;
		
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
		Shoe trainer = new Shoe(0, 0, "SomeTrainer", nikeSupplier, ShoeType.RUNNING, 8000);	
		Shoe flipFlops = new Shoe(1, 1, "SomeFlipFlops", vansSupplier, ShoeType.BEACH, 5000);
		Shoe hikingBoots = new Shoe(2, 2, "SomeHikingBoots", doctorMartinsSupplier, ShoeType.MILITARY, 9000);
		Shoe nikeAirtrainerShoe = new Shoe(3,  3, "SomeNikeShoe", nikeSupplier, ShoeType.SNEAKER, 11000);
		Shoe leatherbootsVans = new Shoe(4,  4, "SomeLeatherBootsVans", vansSupplier, ShoeType.LEATHER_BOOTS, 1200);
		Shoe r9s = new Shoe(5,  5, "SomeR9s", nikeSupplier, ShoeType.FOOTBALL_BOOTS, 15000);
		Shoe sandals = new Shoe(6,  6, "SomeSandals", vansSupplier, ShoeType.WEDDING, 20000);
		Shoe rugbyNike = new Shoe(7,  7, "SomeNikeRugbyShoes", nikeSupplier, ShoeType.RUGBY, 8000);
		Shoe wellies = new Shoe(8,  8, "SomeWellies", doctorMartinsSupplier, ShoeType.WELLIES, 5000);
		Shoe slippers = new Shoe(9,  9, "SomeSlipeprs", doctorMartinsSupplier, ShoeType.SLIPPERS, 2000);
		Shoe balletShoes = new Shoe(10,  10, "SomeBalletShoes", vansSupplier, ShoeType.DANCING, 8000);

		List<Shoe> stockToBeOrdererd = new ArrayList<>();
		StockToBeOrdered stockToBeOrdered = new StockToBeOrderedShopA (stockToBeOrdererd, stock, trainer, 400
				, MAX_STOCK_CAN_HOLD, MAX_NUM_OF_SHOE_TYPES);
		 
		System.out.println(addAndGetFeedback(stockToBeOrdered, trainer, 400));
		System.out.println(addAndGetFeedback(stockToBeOrdered, trainer, 120)); //Should fail
		System.out.println(addAndGetFeedback(stockToBeOrdered, flipFlops, 1));
		System.out.println(addAndGetFeedback(stockToBeOrdered, hikingBoots, 2));
		System.out.println(addAndGetFeedback(stockToBeOrdered, nikeAirtrainerShoe, 3));
		System.out.println(addAndGetFeedback(stockToBeOrdered, leatherbootsVans, 3));
		System.out.println(addAndGetFeedback(stockToBeOrdered, r9s, 4));
		System.out.println(addAndGetFeedback(stockToBeOrdered, balletShoes, 5));
		System.out.println(addAndGetFeedback(stockToBeOrdered, sandals, 6));
		System.out.println(addAndGetFeedback(stockToBeOrdered, rugbyNike, 7));
		System.out.println(addAndGetFeedback(stockToBeOrdered, wellies, 2));
		
		//Next one should fail
		System.out.println("Size of stockToBeOrderedList " + stockToBeOrdered.getStockToBeOrdered().size());
		System.out.println("Next one should fail.");	
		System.out.println(addAndGetFeedback(stockToBeOrdered, slippers, 2)); //Not working
		
		
		System.out.println("Size of stockToBeOrderedList " + stockToBeOrdered.getStockToBeOrdered().size());

	}

}
