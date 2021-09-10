package com.chris.enoch.shoeshop.entity;

import java.math.BigDecimal;

public class Shoe {
	private int id;  //to uniquely identify in database
	private String name;
	private long productId;
	private Supplier supplier;
	private ShoeType shoeType;
	private int priceInCents;
	private GenderAdultChild genderAdultChild;
	private int itemGroupRef;
	private Colour colour;
	private int size;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ShoeType getShoeType() {
		return shoeType;
	}

	public void setShoeType(ShoeType shoeType) {
		this.shoeType = shoeType;
	}
	
	public int getPriceInCents() {
		return priceInCents;
	}

	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenderAdultChild getGenderAdultChild() {
		return genderAdultChild;
	}

	public void setGenderAdultChild(GenderAdultChild genderAdultChild) {
		this.genderAdultChild = genderAdultChild;
	}

	public int getItemGroupRef() {
		return itemGroupRef;
	}

	public void setItemGroupRef(int itemGroupRef) {
		this.itemGroupRef = itemGroupRef;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	public Shoe(int id, long productId, String name, Supplier supplier, ShoeType shoeType, int priceInCents,
			GenderAdultChild genderAdultChild, int itemGroupRef, Colour colour, int size) {
		super();
		this.id = id;
		this.name = name;
		this.productId = productId;
		this.supplier = supplier;
		this.shoeType = shoeType;
		this.priceInCents = priceInCents;
		this.genderAdultChild = genderAdultChild;
		this.itemGroupRef = itemGroupRef;
		this.colour = colour;
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoe other = (Shoe) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
}