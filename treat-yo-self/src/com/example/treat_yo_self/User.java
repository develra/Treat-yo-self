package com.example.treat_yo_self;

import java.util.LinkedList;
import java.util.List;

public class User {
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String pass;
	
	/** The email. */
	private String email;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The account list. */
	private List<Account> accountList;
	
	private Account currAccount;

	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param pass the pass
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param lastName2 
	 */
	public User(String userName, String pass, String email, String firstName, String lastName) {
		this.userName = userName;
		this.pass = pass;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		accountList = new LinkedList<Account>();
	}

	/**
	 * Adds the account.
	 *
	 * @param acc the acc
	 */
	public void addAccount(Account acc) {
		accountList.add(acc);
	}

	/**
	 * Gets the accounts.
	 *
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accountList;
	}

	/**
	 * This is used for populating the ListView in the home activity. It returns an array of strings formatted to display account type followed by the balance.
	 *
	 * @return the string[]
	 */
	public String[] accountArray() {
		return null;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
   /**Gets the email.
    * @return the email
    */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Sets the pass.
	 *
	 * @param pass the new pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Account getCurrAccount(){
		return currAccount;
	}
	
	public void setCurrAccount(Account acc){
		currAccount = acc;
	}
	public String toString() {
		return firstName + " " + lastName;
	}
}
