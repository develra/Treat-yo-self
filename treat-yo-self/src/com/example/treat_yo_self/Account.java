package com.example.treat_yo_self;

import java.util.LinkedList;
import java.util.List;

public class Account {	
	/** The account name. */
	private String accountName;

	/** The balance. */
	private double balance;


	/**transaction linked list*/
	private List<Transaction> transactions;
	
	/**
	 * Instantiates a new account.
	 * 
	 * @param accountName
	 *            the account name
	 * @param balance
	 *            the balance
	 */
	public Account(String accountName, double balance) {
		this.accountName = accountName;
		this.balance = balance;
		this.transactions = new LinkedList<Transaction>();
	}

	/**
	 * Gets the account name.
	 * 
	 * @return the account name
	 */
	public String getAccountName() {
		return accountName;
	}
	
	/**
	 * add a transaction to the account
	 * @param trans
	 */
	public void addTrans(Transaction trans){
		transactions.add(trans);
		double amount = trans.getAmount();
		balance = balance + amount;
	}

	/**
	 * get the transaction list
	 * @return
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}
	/**
	 * Sets the account name.
	 * 
	 * @param accountName the new account name
	 */
	public void setAccountName(String accountName) {
		if (accountName != null) {
			this.accountName = accountName;
		}
	}

	/**
	 * Gets the balance.
	 * 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 * 
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
