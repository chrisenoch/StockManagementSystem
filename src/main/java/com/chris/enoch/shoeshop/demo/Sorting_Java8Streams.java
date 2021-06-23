package com.chris.enoch.shoeshop.demo;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.chris.enoch.shoeshop.LoliShoeShop;
import com.chris.enoch.shoeshop.entity.Address;
import com.chris.enoch.shoeshop.entity.Shoe;
import com.chris.enoch.shoeshop.entity.ShoeType;
import com.chris.enoch.shoeshop.entity.Supplier;
import com.chris.enoch.shoeshop.exceptions.TooManyTypesOfShoesException;
import com.chris.enoch.shoeshop.exceptions.TooMuchStockException;

import static java.util.stream.Collectors.*;


public class Sorting_Java8Streams {
	public static void main(String[] args) {	
		LoliShoeShop loliShoeShop = initLoliShoeShoeShop();	
		List<Shoe> stockList = loliShoeShop.getStockList();
		System.out.println("Items currently in stock: " + stockList.size());
		
		Map<Supplier, List<Shoe>> shoesBySupplier
		= stockList.stream().collect(Collectors.groupingBy(Shoe::getSupplier));
		
		Map<Supplier, List<Shoe>> shoesBySuppliertPriceOver9000Cents
		= stockList.stream().collect(Collectors.groupingBy(Shoe::getSupplier, Collectors
				.filtering(s -> s.getPriceInCents() > 9000, Collectors.toList())));
		
		
		//Most expensive shoe per supplier
		Map<Supplier, Optional<Shoe>> mostExpensiveShoeBySupplier
		= stockList.stream().collect(groupingBy(Shoe::getSupplier, maxBy
				(comparing(Shoe::getPriceInCents))));	
	
		
		//Most expensive shoe per supplier - no optional	
		Map<Supplier, Shoe> mostExpensiveShoeBySupplierNoOptional
		= stockList.stream().collect(groupingBy(Shoe::getSupplier
				, collectingAndThen(maxBy
				(comparing(Shoe::getPriceInCents)), Optional::get)));	
		

		//Max shoe price by supplier
		Map<Supplier, Integer> maxShoePriceBySupplier
		= stockList.stream().collect(groupingBy(Shoe::getSupplier, 
				collectingAndThen(maxBy(comparing(Shoe::getPriceInCents)), s -> s.get().getPriceInCents())));	
		
		
		//Get all prices by supplier
		Map<Supplier, Set<Integer>> allPricesBySupplier = stockList.stream()
				.collect(groupingBy(Shoe::getSupplier 
						,mapping(Shoe::getPriceInCents, toSet())));
			
		//Shoe ids by supplier - as a set
		Map<Supplier, Set<Integer>> shoeIdsBySupplierSetMap = stockList
				.stream().collect(groupingBy(Shoe::getSupplier
						,mapping(Shoe::getId, toSet())));
		
		
		//Get average shoe price by supplier
		Map<Supplier, Double> averageShoePriceBySupplier = stockList.stream()
				.collect(groupingBy(Shoe::getSupplier, averagingDouble(Shoe::getPriceInCents)));
		
		//Task 7 - NESTED MAPPING  shoe ids and their suppliers´ telephone numbers
				Map<Integer, List<String>> supplierTelByShoeId = stockList.stream().collect
						(groupingBy(Shoe::getId
								, mapping(Shoe::getSupplier
									,mapping(Supplier::getAddress
											,mapping(Address::getTelephone, toList())))));
		
		
	}
	
	//in reality, would get this info from database
	private static LoliShoeShop initLoliShoeShoeShop() { 
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
		
		try {
			loliShoeShop.orderStock(trainer, 50);
			loliShoeShop.orderStock(flipFlops, 5);
			loliShoeShop.orderStock(hikingBoots, 7);
			loliShoeShop.orderStock(nikeAirtrainerShoe , 8);
			loliShoeShop.orderStock(leatherbootsVans, 27);
			loliShoeShop.orderStock(r9s, 50);
			loliShoeShop.orderStock(balletShoes, 134);
			loliShoeShop.orderStock(sandals, 113);
			loliShoeShop.orderStock(slippers, 45);
			loliShoeShop.orderStock(wellies, 61);	

		} catch (TooManyTypesOfShoesException | TooMuchStockException e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}	
		
		
		
		
		return loliShoeShop;
	}

}
