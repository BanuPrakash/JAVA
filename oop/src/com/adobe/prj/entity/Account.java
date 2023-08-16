/**
 * 
 */
package com.adobe.prj.entity;

/**
 * Business entity to represent Banking account.
 * 
 * @author banuprakash
 * @version 1.0
 * 
 */
public class Account {
	private double balance; // state, instance variable
	private String accNo; // state, instance variable
	
	// default constructor
	public Account() {
	}

	// parameterized constructor
	public Account(String accNo, double balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getAccNo() {
		return this.accNo;
	}
}
