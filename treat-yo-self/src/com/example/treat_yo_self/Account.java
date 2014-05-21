package com.example.treat_yo_self;

public class Account {	
	 /** The account name. */
    private String accountName;

    /** The balance. */
    private double balance;

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
