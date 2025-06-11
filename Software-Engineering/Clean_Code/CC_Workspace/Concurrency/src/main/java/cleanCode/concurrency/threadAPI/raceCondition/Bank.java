package cleanCode.concurrency.threadAPI.raceCondition;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String name;
	private List<Account> accounts;
	
	Bank(String name){
		this.name = name;
		accounts = new ArrayList<>();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public synchronized boolean transfer(Account sender, Account reciever, int amount) {
		
		if(!accountExists(sender)) {
			System.out.println("Sender account does not exist in bank");
			return false;
		}
		
		if(!accountExists(reciever)) {
			System.out.println("Reciever account does not exist in bank");
			return false;
		}
		
		if(sender.withdraw(amount)) {
			reciever.deposit(amount);
			return true;
		}
		else
			return false;
	}
	
	private boolean accountExists(Account custAcc) {
		if(custAcc == null) {
			System.out.println("Dont pass null accounts");
			return false;
		}
			
		for(Account account : accounts) {
			if(custAcc.getCustomer().equalsIgnoreCase(account.getCustomer()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", accounts=" + accounts + "]";
	}
	
}
