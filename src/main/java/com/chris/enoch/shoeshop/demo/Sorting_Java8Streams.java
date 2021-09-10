package com.chris.enoch.shoeshop.demo;

import static java.util.Comparator.comparing;
import static com.chris.enoch.shoeshop.entity.StockToBeOrderedUtils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.chris.enoch.shoeshop.entity.Address;
import com.chris.enoch.shoeshop.entity.Colour;
import com.chris.enoch.shoeshop.entity.GenderAdultChild;
import com.chris.enoch.shoeshop.entity.Shoe;
import com.chris.enoch.shoeshop.entity.ShoeType;
import com.chris.enoch.shoeshop.entity.CurrentStock;
import com.chris.enoch.shoeshop.entity.StockToBeOrdered;
import com.chris.enoch.shoeshop.entity.StockToBeOrderedShopA;
import com.chris.enoch.shoeshop.entity.Supplier;

import static java.util.stream.Collectors.*;

import java.time.LocalDateTime;


public class Sorting_Java8Streams {
	private static final int MAX_STOCK_CAN_HOLD = 500;
	private static final int MAX_NUM_OF_SHOE_TYPES = 10;
	private static CurrentStock stock = new CurrentStock(new ArrayList<>());

	public static void main(String[] args) {	
		//Init Stock				
		StockToBeOrdered stockToBeOrdered = initStockTobeOrdered();	
		
		List<Shoe> stockToBeOrderedList = stockToBeOrdered .getStockToBeOrdered();
		System.out.println("Size of stockToBeOrderedList: " + stockToBeOrderedList.size());
		
		Map<Supplier, List<Shoe>> shoesBySupplier
		= stockToBeOrderedList.stream().collect(Collectors.groupingBy(Shoe::getSupplier));
		
		Map<Supplier, List<Shoe>> shoesBySuppliertPriceOver9000Cents
		= stockToBeOrderedList.stream().collect(Collectors.groupingBy(Shoe::getSupplier, Collectors
				.filtering(s -> s.getPriceInCents() > 9000, Collectors.toList())));
		
		
		//Most expensive shoe per supplier
		Map<Supplier, Optional<Shoe>> mostExpensiveShoeBySupplier
		= stockToBeOrderedList.stream().collect(groupingBy(Shoe::getSupplier, maxBy
				(comparing(Shoe::getPriceInCents))));	
	
		
		//Most expensive shoe per supplier - no optional	
		Map<Supplier, Shoe> mostExpensiveShoeBySupplierNoOptional
		= stockToBeOrderedList.stream().collect(groupingBy(Shoe::getSupplier
				, collectingAndThen(maxBy
				(comparing(Shoe::getPriceInCents)), Optional::get)));	
		

		//Max shoe price by supplier
		Map<Supplier, Integer> maxShoePriceBySupplier
		= stockToBeOrderedList.stream().collect(groupingBy(Shoe::getSupplier, 
				collectingAndThen(maxBy(comparing(Shoe::getPriceInCents)), s -> s.get().getPriceInCents())));	
		
		
		//Get all prices by supplier
		Map<Supplier, Set<Integer>> allPricesBySupplier = stockToBeOrderedList.stream()
				.collect(groupingBy(Shoe::getSupplier 
						,mapping(Shoe::getPriceInCents, toSet())));
			
		//Shoe ids by supplier - as a set
		Map<Supplier, Set<Integer>> shoeIdsBySupplierSetMap = stockToBeOrderedList
				.stream().collect(groupingBy(Shoe::getSupplier
						,mapping(Shoe::getId, toSet())));
		
		
		//Get average shoe price by supplier
		Map<Supplier, Double> averageShoePriceBySupplier = stockToBeOrderedList.stream()
				.collect(groupingBy(Shoe::getSupplier, averagingDouble(Shoe::getPriceInCents)));
		
		//NESTED MAPPING  shoe ids and their suppliers´ telephone numbers
				Map<Integer, List<String>> supplierTelByShoeId = stockToBeOrderedList.stream().collect
						(groupingBy(Shoe::getId
								, mapping(Shoe::getSupplier
									,mapping(Supplier::getAddress
											,mapping(Address::getTelephone, toList())))));
		
		
	}
	
	//in reality, would get this info from database
	private static StockToBeOrdered initStockTobeOrdered() { 
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
		//Init shoes - Improve variable names			
		Shoe trainer = new Shoe(0, 0, "SomeTrainer", nikeSupplier, ShoeType.RUNNING, 8000, GenderAdultChild.MALE, 1, Colour.BLACK, 40);	
		Shoe flipFlops = new Shoe(1, 1, "SomeFlipFlops", vansSupplier, ShoeType.BEACH, 5000, GenderAdultChild.FEMALE, 2, Colour.BLACK, 40);
		Shoe hikingBoots = new Shoe(2, 2, "SomeHikingBoots", doctorMartinsSupplier, ShoeType.MILITARY, 9000, GenderAdultChild.MALE, 2, Colour.WHITE, 42);
		Shoe nikeAirtrainerShoe = new Shoe(3,  3, "SomeNikeShoe", nikeSupplier, ShoeType.SNEAKER, 11000, GenderAdultChild.MALE, 3, Colour.BLACK, 40);
		Shoe leatherbootsVans = new Shoe(4,  4, "SomeLeatherBootsVans", vansSupplier, ShoeType.LEATHER_BOOTS, 1200, GenderAdultChild.FEMALE, 4, Colour.BLACK, 46);
		Shoe r9s = new Shoe(5,  5, "SomeR9s", nikeSupplier, ShoeType.FOOTBALL_BOOTS, 15000, GenderAdultChild.MALE, 5, Colour.RED, 39);
		Shoe sandals = new Shoe(6,  6, "SomeSandals", vansSupplier, ShoeType.WEDDING, 20000, GenderAdultChild.FEMALE, 1, Colour.WHITE, 40);
		Shoe rugbyNike = new Shoe(7,  7, "SomeNikeRugbyShoes", nikeSupplier, ShoeType.RUGBY, 8000, GenderAdultChild.MALE, 1, Colour.BLACK, 40);
		Shoe wellies = new Shoe(8,  8, "SomeWellies", doctorMartinsSupplier, ShoeType.WELLIES, 5000, GenderAdultChild.MALE, 1, Colour.BLACK, 40);
		Shoe slippers = new Shoe(9,  9, "SomeSlipeprs", doctorMartinsSupplier, ShoeType.SLIPPERS, 2000, GenderAdultChild.MALE, 1, Colour.BLACK, 40);
		Shoe balletShoes = new Shoe(10,  10, "SomeBalletShoes", vansSupplier, ShoeType.DANCING, 8000, GenderAdultChild.FEMALE, 1, Colour.BLACK, 38);
		
		List<Shoe> stockToBeOrdererd = new ArrayList<>();
		StockToBeOrdered stockToBeOrdered = new StockToBeOrderedShopA (stockToBeOrdererd, stock, trainer
				,LocalDateTime.now(), MAX_STOCK_CAN_HOLD, MAX_NUM_OF_SHOE_TYPES);
		
		
		System.out.println(addAndGetFeedback(stockToBeOrdered, trainer, 50));
		System.out.println(addAndGetFeedback(stockToBeOrdered, flipFlops, 5));
		System.out.println(addAndGetFeedback(stockToBeOrdered, hikingBoots, 7));
		System.out.println(addAndGetFeedback(stockToBeOrdered, nikeAirtrainerShoe, 8));
		System.out.println(addAndGetFeedback(stockToBeOrdered, leatherbootsVans, 27));
		System.out.println(addAndGetFeedback(stockToBeOrdered, r9s, 50));
		System.out.println(addAndGetFeedback(stockToBeOrdered, balletShoes, 134));
		System.out.println(addAndGetFeedback(stockToBeOrdered, sandals, 113));
		System.out.println(addAndGetFeedback(stockToBeOrdered, slippers, 45));
		System.out.println(addAndGetFeedback(stockToBeOrdered, wellies, 61));

		
		return stockToBeOrdered;
	}

}
