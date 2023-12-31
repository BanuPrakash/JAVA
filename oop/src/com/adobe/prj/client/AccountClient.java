package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		System.out.println("Count " + Account.getCount()); // 0
		Account rahulAcc = new Account("SA102", 5000.00); // parameterized constructor
		System.out.println("Count " + Account.getCount()); // 1
		Account swethaAcc = new Account("SA991", 9000.00); 
		System.out.println("Count " + Account.getCount()); // 2
		
		swethaAcc.deposit(8122);
		rahulAcc.deposit(12000.00);
		
		System.out.println("Rahul Acc");
		System.out.println("ACC " + rahulAcc.getAccNo());
		System.out.println("Balance " + rahulAcc.getBalance());
		
		System.out.println("Swetha Acc");
		System.out.println("ACC " + swethaAcc.getAccNo());
		System.out.println("Balance " + swethaAcc.getBalance());
		
	}

}
