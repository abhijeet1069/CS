package cleanCode.concurrency.threadAPI.raceCondition;

// Using boolean to avoid try catch, and ensure consistent state

public class Account {
	
	private String customer;
	private int balance;
	
	public Account(String customer, int intitalBalance) {
		if(intitalBalance > 0) {
			this.customer = customer;
			this.balance = intitalBalance;
		}
			
		else {
			System.out.println("Please enter a positive amount");
			this.balance = 0;
			this.customer = "unknown";
		}	
	}
	
	public synchronized boolean withdraw(int amount) {
		if(balance-amount >= 0) {
			balance = balance-amount;
			return true;
		}
		else {
			System.out.println("Insufficient balance!! For customer "
		+customer+" amount = "+amount+" balance = "+balance);
			return false;
		}
			
	}
	
	public synchronized void  deposit(int amount) {
		balance += amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Account [customer=" + customer + ", balance=" + balance + "]";
	}
}
