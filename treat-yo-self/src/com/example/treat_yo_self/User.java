package com.example.treat_yo_self;

public class User {

	/** The user name. */
	private String userName;

	/** The password. */
	private String pass;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The account list. */
	private Account account1;
	private Account account2;
	private Account account3;

	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param pass the password
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public User(String userName, String pass, String firstName, String lastName, String accountname1, String accountname2, String accountname3, double amount1, double amount2, double amount3) {
		this.userName = userName;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.account1 = new Account(accountname1, amount1);
		this.account2 = new Account(accountname2, amount2);
		this.account3 = new Account(accountname3, amount3);
	}

	/**
	 * Gets the accounts.
	 *
	 * @return the accounts
	 */
	public Account[] getAccounts() {
		Account[] accountarr = new Account[3];
		accountarr[1] = account1;
		accountarr[2] = account2;
		accountarr[3] = account3;
		return accountarr;
	}


	/**
	 *  get account1
	 * @return
	 */
	public Account getAccount1() {
		return account1;
	}
	
	/**
	 *  get account2
	 * @return
	 */
	public Account getAccount2() {
		return account1;
	}
	
	/**
	 *  get account3
	 * @return
	 */
	public Account getAccount3() {
		return account1;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
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

	public String toString() {
		return firstName + " " + lastName;
	}
}
