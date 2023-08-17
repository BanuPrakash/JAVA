package com.adobe.prj.client;

interface Computation {
	int compute(int x, int y);
}

// public class AddCompute implements Computation {...

public class InterfaceExample {

	public static void main(String[] args) {
		Computation addCompute = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(addCompute.compute(5, 4)); // 9
		
		// FunctionalInterface --> interface with one method to implement
		// lambda
		Computation subtractCompute = (int x, int y) -> {
			return x - y;
		};
		
		System.out.println(subtractCompute.compute(5, 4)); // 1
		
		// type inference
		Computation multiCompute = (x,y) -> x * y;
		System.out.println(multiCompute.compute(5, 4)); // 20
	}

}
