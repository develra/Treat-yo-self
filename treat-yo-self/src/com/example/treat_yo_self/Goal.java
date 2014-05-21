package com.example.treat_yo_self;

public class Goal {


	/** The goal. */
	private String goal;

	/** The amount of the goal. */
	private double amount;

/**
 * constructor of goal
 * @param goal
 * @param amount
 */
	public Goal(String goal, double amount) {
			this.goal = goal;
			this.amount = amount;
	}
	
	/**
	 * get goal
	 */
	public String getGoal() {
		return goal;
	}
	
	/**
	 * set goal
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	/**
	 * get amount
	 */
	
	public double getAmount() {
		return amount;
	}
	
	/**
	 * set amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
