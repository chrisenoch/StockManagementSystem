package com.chris.enoch.shoeshop;

public class ClassB extends ClassA {

	@Override
	int test() {
		return 10;
	}
	
	public static void main(String[] args) {
		ClassA a = new ClassB();
		System.out.println(a.retrieveMe());
		
		
	}

}
