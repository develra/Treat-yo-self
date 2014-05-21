package com.example.treat_yo_self;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	
	import net.sourceforge.jtds.jdbc.*;
	
	public void query2()
	{
	Log.i("Android"," MySQL Connect Example.");
	Connection conn = null;
	try {
	String driver = "net.sourceforge.jtds.jdbc.Driver";
	Class.forName(driver).newInstance();
	//test = com.microsoft.sqlserver.jdbc.SQLServerDriver.class;
	String connString = "updb1.up.ist.psu.edu;encrypt=false;user=sqlpzw5095;password=RqUGthh6;instance=SQLEXPRESS;";
	String username = "sqlpzw5095";
	String password = "RqUGthh6";
	conn = DriverManager.getConnection(connString,username,password);
	Log.w("Connection","open");
	Statement stmt = conn.createStatement();
	ResultSet reset = stmt.executeQuery("select * from TableName");
	
	//Print the data to the console
	while(reset.next()){
	Log.w("Data:",reset.getString(3));
	//              Log.w("Data",reset.getString(2));
	}
	conn.close();
	
	} catch (Exception e)
	{
	Log.w("Error connection","" + e.getMessage());
	}
	}



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
