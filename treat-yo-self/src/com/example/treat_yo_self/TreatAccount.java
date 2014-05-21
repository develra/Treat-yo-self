package com.example.treat_yo_self;

/**
 * 
 * treat account
 *
 */
public class TreatAccount extends Account {

	double amountEarned;
	/**
	 * constructor
	 * @param accountName
	 * @param balance
	 */
	public TreatAccount(String accountName, double balance) {
		super(accountName, balance);
		// TODO Auto-generated constructor stub
		amountEarned = 0;
	}

	/**
	 * add amount to the account
	 * @param earned
	 */
	public void addAmountEarned(double earned) {
		if (amountEarned + earned <= super.getBalance()){
			amountEarned += earned;
		} else {
			amountEarned = super.getBalance();
		}
	}
	
	/**
	 * get Percentage of how much earned
	 * @return
	 */
	public double getPercentage() {
		return amountEarned / super.getBalance();
	}
}